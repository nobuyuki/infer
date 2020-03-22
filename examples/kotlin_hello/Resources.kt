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
import java.io.FileOutputStream
import java.io.IOException

public class Resources {
  companion object {
    fun allocateResource() : FileOutputStream? {
      try {
        val file = File("foo.txt");
        return FileOutputStream(file);
      } catch (e : IOException) {
        return null
      }
    }
  }
}
