/*
 * Copyright (c) 2015 - present Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the BSD style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */

package infer.inferandroidexample

import android.support.v7.app.ActionBarActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import java.io.FileOutputStream
import java.io.IOException
import java.util.Calendar


class MainActivity : ActionBarActivity() {

    private val day: String?
        get() = if (Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
            "Wednesday"
        } else {
            otherOutput()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val s = day
        val length = s!!.length
        writeToFile()
    }

    private fun otherOutput(): String? {
        return null
    }

    private fun writeToFile() {
        val arr = byteArrayOf(1, 2, 3)
        val fis: FileOutputStream
        try {
            fis = FileOutputStream("file.txt")
            fis.write(arr)
            fis.close()
        } catch (e: IOException) {
            //Deal with exception
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

    private fun inferShouldNotReport() {
        // Generated.java is supposed to be skipped by infer, thus even though
        // Generated.returnsNull() returns null, infer is not supposed to know
        // about it hence should not report an NPE here
        val o = Generated.returnsNull()
        o!!.toString()
    }

}
