/*
 * Copyright (c) 2015 - present Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the BSD style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */

package hello

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import java.util.Random

class Hello {

  fun doesNotCauseNPE() {
    val a = Pointers.mayReturnNull(10)
    a!!.method()
  }

  fun mayCauseNPE() {
    val rng = Random()
    val a = Pointers.mayReturnNull(rng.nextInt())
    // FIXME: should check for null before calling method()
    a!!.method()
  }

  fun mayLeakResource() {
    val stream = Resources.allocateResource();
    stream ?: return

    try {
      stream.write(12)
    } finally {
      // FIXME: should close the stream
    }
  }

  /**
   * This method should be rewritten with nested try { ... } finally {
   * ... } statements, or the possible exception raised by fis.close()
   * should be swallowed.
   */
  fun twoResources() {
    var fis : FileInputStream? = null
    var fos : FileOutputStream? = null
    try {
      fis = FileInputStream(File("whatever.txt"))
      fos = FileOutputStream(File("everwhat.txt"))
      fos.write(fis.read())
    } finally {
      fis?.close()
      fos?.close()
    }
  }

}
