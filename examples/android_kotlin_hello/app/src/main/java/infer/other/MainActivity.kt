/*
 * Copyright (c) 2015 - present Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the BSD style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */

package infer.other

import android.annotation.SuppressLint
import android.support.v7.app.ActionBarActivity
import android.os.Bundle

class MainActivity : ActionBarActivity() {

    internal fun source(): Any? {
        return null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        source()!!.toString()
    }

    @SuppressLint("NULL_DEREFERENCE")
    internal fun shouldNotBeReported() {
        source()!!.toString()
    }

}
