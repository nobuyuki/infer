# Copyright (c) 2017 - present Facebook, Inc.
# All rights reserved.
#
# This source code is licensed under the BSD style license found in the
# LICENSE file in the root directory of this source tree. An additional grant
# of patent rights can be found in the PATENTS file in the same directory.

SOURCES = Resources.kt Pointers.kt Hello.kt
OBJECTS = $(SOURCES:.kt=.class)

all: Hello.class

%.class: $(SOURCES)
	kotlinc $(SOURCES)

clean:
	rm -rf $(OBJECTS)
