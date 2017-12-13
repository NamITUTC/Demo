package com.example.nam.demobasekotlin.manager

import android.text.TextUtils
import io.realm.Realm
import io.realm.RealmObject
import io.realm.RealmQuery
import io.realm.Sort

/**
 * Created by nam on 12/12/2017.
 */
class RealmManager<T : RealmObject> {
    companion object {


        fun <T : RealmObject> save(objects: T) {
            val realm: Realm = Realm.getDefaultInstance()
            try {
                realm.beginTransaction()
                realm.copyToRealmOrUpdate(objects)
                realm.commitTransaction()

            } finally {
                realm.close()
            }
        }

        fun <T : RealmObject> deleteAll(clazz: Class<T>) {
            val realm = Realm.getDefaultInstance()
            try {
                realm.run {
                    beginTransaction()
                    delete(clazz)
                    commitTransaction()
                }
            } finally {
                realm.close()
            }

        }

        fun <T : RealmObject> deleteWhere(clazz: Class<T>, where: OnQuerySearch<T>) {
            val realm = Realm.getDefaultInstance()
            try {
                realm.beginTransaction()
                var query = realm.where(clazz)
                query = where.onQuery(query)
                val listResults = query.findAll()
                if (listResults != null && listResults.size > 0)
                    listResults.deleteAllFromRealm()
                realm.commitTransaction()
            } finally {
                realm.close()
            }
        }

        fun <T : RealmObject> deleteWhere(clazz: Class<T>, where: String,values:Int) {
            val realm = Realm.getDefaultInstance()
            try {
                realm.beginTransaction()
                var query = realm.where(clazz).equalTo(where,values)
                //query = where.onQuery(query)
                val listResults = query.findAll()
                if (listResults != null && listResults.size > 0)
                    listResults.deleteAllFromRealm()
                realm.commitTransaction()
            } finally {
                realm.close()
            }
        }

        fun <T : RealmObject> findFirst(clazz: Class<T>): T? {
            return findFirst(clazz, null)
        }

        fun <T : RealmObject> findFirst(clazz: Class<T>, where: OnQuerySearch<T>?): T? {
            val realm = Realm.getDefaultInstance()
            try {
                realm.beginTransaction()
                var query = realm.where(clazz)
                if (where != null) {
                    query = where.onQuery(query)
                }
                val data: T? = query.findFirst()
                if (data != null)
                    return realm.copyFromRealm(data)
                else return null
                realm.commitTransaction()
            } finally {
                realm.close()
            }
        }


        fun <T : RealmObject> findAll(clazz: Class<T>, sort: String?, limit: Int): List<T> {
            return findAll(clazz, sort, limit, null)
        }

        fun <T : RealmObject> findAll(clazz: Class<T>, sort: String?): List<T> {
            return findAll(clazz, sort, -1)
        }

        fun <T : RealmObject> findAll(clazz: Class<T>): List<T> {
            return findAll(clazz, null)
        }

        fun <T : RealmObject> findAll(clazz: Class<T>, sort: String?, limit: Int, querySearch: OnQuerySearch<T>?): List<T> {
            val realm = Realm.getDefaultInstance()
            try {
                var query = realm.where(clazz)
                if (querySearch != null)
                    query = querySearch.onQuery(query)
                val listData = if (TextUtils.isEmpty(sort)) query.findAll() else query.findAllSorted(sort, Sort.DESCENDING)
                var listResult: List<T> = ArrayList()
                if (listData != null && listData.size > 0) {
                    listResult = realm.copyFromRealm(listData)
                }
                return if (limit > 0 && limit < listResult.size) listResult.subList(0, limit) else listResult
                realm.close()
            } finally {
                realm.close()
            }
        }


        interface OnQuerySearch<E : RealmObject> {
            fun onQuery(query: RealmQuery<E>): RealmQuery<E>
        }
    }
}