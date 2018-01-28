@file:Suppress("DEPRECATION")

package com.example.nam.demobasekotlin.ui.menu.subfragment.chatboot

import android.app.Application
import android.app.ProgressDialog
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseView
import com.example.nam.demobasekotlin.models.Message
import com.example.nam.demobasekotlin.ui.menu.subfragment.chatboot.adapter.ChatBootAdapter
import com.example.nam.demobasekotlin.ui.menu.subfragment.chatboot.dialog.DialogUpdateFragment
import com.ibm.mobilefirstplatform.clientsdk.android.analytics.api.Analytics
import com.ibm.mobilefirstplatform.clientsdk.android.core.api.BMSClient
import com.ibm.mobilefirstplatform.clientsdk.android.core.api.Response
import com.ibm.mobilefirstplatform.clientsdk.android.core.api.ResponseListener
import com.ibm.watson.developer_cloud.conversation.v1.Conversation
import com.ibm.watson.developer_cloud.conversation.v1.model.*
import com.ibm.watson.developer_cloud.http.ServiceCallback
import io.realm.internal.SyncObjectServerFacade.getApplicationContext
import kotlinx.android.synthetic.main.fragment_chatboot.*
import org.json.JSONObject
import java.util.*
import java.util.logging.Logger
import javax.inject.Inject
import kotlin.collections.HashMap

/**
 * Created by nam on 29/12/2017.
 */
class ChatBootFragment : BaseFragment() {

    @Inject
    lateinit var presenter: ChatBootPresenter
    private var progressDialog: ProgressDialog? = null
    private var mAdapter: ChatBootAdapter? = null
    private var messageArrayList: MutableList<Message>? = null
    private var context: MutableMap<String, Any> = HashMap()
    private var initialRequest: Boolean = false
    private var myLogger: Logger? = null
    private var workspace_id: String? = null
    private var conversationUsername: String? = null
    private var conversationPassword: String? = null
    private var STT_username: String? = null
    private var STT_password: String? = null
    private var analytics_APIKEY: String? = null
    private lateinit var dialogUpdateFragment: DialogUpdateFragment

    override fun <T : BaseView> getPresenter(): BasePresenter<T>? {
        return presenter as BasePresenter<T>
    }

    override fun injectDependence() {
        component.inject(this)
    }

    override fun getLayOutRes(): Int {
        return R.layout.fragment_chatboot
    }

    override fun initData() {

    }

    override fun initView() {

        conversationUsername = this.getString(R.string.conversationUsername)
        conversationPassword = this.getString(R.string.conversationPassword)
        workspace_id = this.getString(R.string.workspace_id)
        STT_username = this.getString(R.string.STT_username)
        STT_password = this.getString(R.string.STT_password)
        analytics_APIKEY = this.getString(R.string.mobileanalytics_apikey)
        //Bluemix Mobile Analytics
        BMSClient.getInstance().initialize(getApplicationContext(), BMSClient.REGION_US_SOUTH)
        //Analytics is configured to record lifecycle events.
        Analytics.init(Application(), "WatBot", analytics_APIKEY, false, Analytics.DeviceEvent.ALL)
        //Analytics.send();
        myLogger = Logger.getLogger("myLogger")
        progressDialog = ProgressDialog(activity)

        // Send recorded usage analytics to the Mobile Analytics Service
        Analytics.send(object : ResponseListener {
            override fun onSuccess(response: Response) {
                // Handle Analytics send success here.
            }

            override fun onFailure(response: Response, throwable: Throwable, jsonObject: JSONObject) {
                // Handle Analytics send failure here.
            }
        })

        // Send logs to the Mobile Analytics Service
        /*Logger.send(object : ResponseListener() {
            fun onSuccess(response: Response) {
                // Handle Logger send success here.
            }

            fun onFailure(response: Response, throwable: Throwable, jsonObject: JSONObject) {
                // Handle Logger send failure here.
            }
        })
*/
        /*  val customFont = "Montserrat-Regular.ttf"
          val typeface = Typeface.createFromAsset(getAssets(), customFont)
          inputMessage.setTypeface(typeface)
  */
        messageArrayList = mutableListOf()
        mAdapter = ChatBootAdapter(messageArrayList!!, object : ChatBootAdapter.ITraining {
            override fun train(mesage: String) {
                dialogUpdateFragment = DialogUpdateFragment(mesage, object : ChatBootAdapter.ITraining {
                    override fun train(message: String) {
                        updateChatBoot(message)
                    }


                })
            }
        })


        val layoutManager = LinearLayoutManager(activity)
        layoutManager.stackFromEnd = true
        recycler_view!!.setLayoutManager(layoutManager)
        recycler_view?.setItemAnimator(DefaultItemAnimator())
        recycler_view!!.setAdapter(mAdapter)
        message.text = null
        this.initialRequest = true
        sendMessage()

        btn_send!!.setOnClickListener(View.OnClickListener {
            // if (checkInternetConnection()) {
            sendMessage()
            //}
        })


        // Speech-to-Text Record Audio permission
        // Sending a message to Watson Conversation Service


        fun showError(e: Exception) {
            activity!!.runOnUiThread({
                Toast.makeText(activity, e.message, Toast.LENGTH_SHORT).show()
                e.printStackTrace()
            })
        }


    }

    private fun updateChatBoot(message: String) {
        progressDialog!!.show()
        val thread = Thread(Runnable {
            try {
                val service = Conversation(Conversation.VERSION_DATE_2017_05_26)
                service.setUsernameAndPassword(conversationUsername, conversationPassword)
                //Create Example
                val createExampleOptions = CreateExampleOptions.Builder()
                        .workspaceId(workspace_id)
                        .intent("example")
                        .text(message)
                        .build()
                service.createExample(createExampleOptions).enqueue(object : ServiceCallback<Example> {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    override fun onResponse(response: Example) {
                        Log.e("Add Example : ", "Add succesfull!")
                        val list = ArrayList<String>()
                        list.add(message)
                        val value = "example_" + Calendar.getInstance().timeInMillis
                        val createValueOptions = CreateValueOptions.Builder()
                                .workspaceId(workspace_id)
                                .entity("entity_example")
                                .value(value)
                                .synonyms(list)
                                .build()
                        service.createValue(createValueOptions).enqueue(object : ServiceCallback<Value> {
                            override fun onResponse(response: Value) {
                                Log.e("Add into Ennity : ", "Add succesfull!")
                                //Add into Dialog.
                                //   val output = HashMap
                                //output.put("text", dialogUpdateFragment.getAnswer())
                                val createDialogNodeOptions = CreateDialogNodeOptions.Builder()
                                        .workspaceId(workspace_id)

                                        .dialogNode("node_" + Calendar.getInstance().timeInMillis)
                                        .conditions("@entity_example:" + value)
                                        //         .output(output)
                                        .nodeType("response_condition")
                                        .parent("node_8_1514516712522")
                                        .build()
                                service.createDialogNode(createDialogNodeOptions).enqueue(object : ServiceCallback<DialogNode> {
                                    override fun onResponse(response: DialogNode) {
                                        //dialogUpdateFragment.dismiss()
                                        activity!!.runOnUiThread({ progressDialog!!.dismiss() })
                                    }

                                    override fun onFailure(e: Exception) {
                                        Log.e("Add Dialog Error: ", e.message)
                                        activity!!.runOnUiThread({ progressDialog!!.dismiss() })
                                    }
                                })

                            }

                            override fun onFailure(e: Exception) {
                                Log.e("Entity Value Error: ", e.message)
                                activity!!.runOnUiThread({
                                    Toast.makeText(activity, e.message, Toast.LENGTH_SHORT)
                                    progressDialog!!.dismiss()
                                })
                            }
                        })
                    }

                    override fun onFailure(e: Exception) {
                        Log.e("Error: ", e.message)
                        activity!!.runOnUiThread({
                            Toast.makeText(activity, e.message, Toast.LENGTH_SHORT)
                            progressDialog!!.dismiss()
                        })
                    }
                })

            } catch (e: Exception) {
                e.printStackTrace()
                activity!!.runOnUiThread({ progressDialog!!.dismiss() })
            }
        })
        thread.start()
    }


    private fun sendMessage() {
        val inputmessage = message.text.toString().trim { it <= ' ' }
        if (!this.initialRequest) {
            val inputMessage = Message("1", inputmessage)

            messageArrayList!!.add(inputMessage)
            // myLogger.info("Sending a message to Watson Conversation Service")

        } else {
            val inputMessage = Message("100", inputmessage)
            this.initialRequest = false
            //   Toast.makeText(getApplicationContext(), "Tap on the message for Voice", Toast.LENGTH_LONG).show()

        }

        message.text = null
        mAdapter!!.notifyDataSetChanged()

        val thread = Thread(Runnable {
            try {
                val service = Conversation(Conversation.VERSION_DATE_2017_05_26)
                service.setUsernameAndPassword(conversationUsername, conversationPassword)
                val inputData = InputData.Builder(inputmessage).build()
                val newMessage = MessageOptions.Builder()
                        .input(inputData)
                        .workspaceId(workspace_id)
                        .build()
                val response = service.message(newMessage).execute()
                //                    IntentExportResponse intent =  service.getIntent(workspace_id,"drug",false).execute();

                //Passing Context of last conversation
                if (response!!.getContext() != null) {
                    context.clear()
                    context = response!!.getContext()
                }
                val outMessage = Message()
                if (response != null) {
                    if (response!!.getOutput() != null && response!!.getOutput().containsKey("text")) {
                        val responseList = response!!.getOutput().get("text") as ArrayList<*>
                        if (null != responseList && responseList.size > 0) {
                            outMessage.message = responseList[0] as String
                            outMessage.id = "2"
                        }
                        if (response!!.getIntents().size == 0 && messageArrayList!!.size > 1) {
                            val oldMassage = messageArrayList!!.get(messageArrayList!!.size - 1)
                            oldMassage.id = "3"
                        }
                        messageArrayList!!.add(outMessage)
                    }

                    activity!!.runOnUiThread({
                        mAdapter!!.notifyDataSetChanged()
                        if (mAdapter!!.getItemCount() > 1) {
                            recycler_view!!.getLayoutManager().smoothScrollToPosition(recycler_view,
                                    null, mAdapter!!.getItemCount() - 1)
                        }
                    })
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        })
        thread.start()
    }


}