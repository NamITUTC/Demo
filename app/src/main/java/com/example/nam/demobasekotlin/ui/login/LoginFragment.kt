package com.example.nam.demobasekotlin.ui.login

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.Util.ToastUltil
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseView
import com.example.nam.demobasekotlin.manager.RealmManager
import com.example.nam.demobasekotlin.models.Data
import com.example.nam.demobasekotlin.models.Note
import com.example.nam.demobasekotlin.ui.login.adapter.NoteAdapter
import com.example.nam.demobasekotlin.view.Constant
import com.example.nam.demobasekotlin.view.Router
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

/**
 * Created by nam on 08/12/2017.
 */
class LoginFragment : BaseFragment(), View.OnClickListener, NoteAdapter.IClick, LoginView {
    override fun LoadData(data: List<Data>) {

    }

    @Inject
    lateinit var mRouter: Router
    @Inject
    lateinit var presenter: LoginPresenter

    private var nodes: MutableList<Note> = mutableListOf()
    private lateinit var nodeAdapter: NoteAdapter
    private var idCurrent: Int = -1

    override fun injectDependence() {
        component.inject(this)
    }

    override fun getLayOutRes(): Int {

        return R.layout.fragment_login
    }

    override fun initData() {
        presenter.show(5, 6)
    }

    override fun initView() {
        btn_chuyen.setOnClickListener {
            presenter.next()
            activity.intent.getBundleExtra(Constant.HELLO)
            //var intent=Intent()
            //intent.setAction("MyBroadcast")
            //intent.putExtra("value",1000)

            // sendBroadcast(intent)
            var bundle: Bundle = Bundle()
            bundle.putString("a", "Nam")
            bundle.putString("b", "Nguyen")

            //intent.putExtra("bundle",bundle)
            mRouter.goToMenu()
            var ss: String? = null
            if (ss != null) {
                Toast.makeText(activity, ss!!, Toast.LENGTH_LONG).show()
            }

        }
        btn_add.setOnClickListener(this)
        btn_view.setOnClickListener(this)

        nodeAdapter = NoteAdapter(nodes, this)
        rc_list.apply {
            adapter = nodeAdapter
            layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        }
    }


    override fun getPresenter(): BasePresenter<BaseView> {
        return presenter
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.btn_add -> {
                var note = Note()
                var notes = RealmManager.findAll(Note::class.java)
                note.id = notes.size
                note.title = txt_title.text.toString()
                note.content = txt_content.text.toString()
                presenter.addNote(note)
            }
            R.id.btn_view -> presenter.viewNote()
        }
    }

    override fun setText(s: Int) {
        txt_test.text = s.toString()
    }

    override fun click(note: Note) {
        ToastUltil.show(activity, note.id.toString())
        idCurrent = note.id
        presenter.deleteNote(idCurrent)
    }

    override fun load(nodes: List<Note>) {
        nodeAdapter.notes = nodes
        nodeAdapter.notifyDataSetChanged()
    }

}