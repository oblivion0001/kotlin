/*
 * Copyright 2010-2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.idea.caches.resolve

import org.jetbrains.kotlin.config.TargetPlatformKind

class MultiModuleLineMarkerTest : AbstractMultiModuleLineMarkerTest() {
    fun testFromCommonToJvmHeader() {
        val header = module("header")
        header.setPlatformKind(TargetPlatformKind.Common)

        val jvm = module("jvm")
        jvm.setPlatformKind(TargetPlatformKind.Jvm.JVM_1_6)
        jvm.enableMultiPlatform()
        jvm.addDependency(header)

        checkHighlightingInAllFiles()
    }

    fun testFromCommonToJvmImpl() {
        val header = module("header")
        header.setPlatformKind(TargetPlatformKind.Common)

        val jvm = module("jvm")
        jvm.setPlatformKind(TargetPlatformKind.Jvm.JVM_1_6)
        jvm.enableMultiPlatform()
        jvm.addDependency(header)

        checkHighlightingInAllFiles()
    }

    fun testFromClassToAlias() {
        val header = module("header")
        header.setPlatformKind(TargetPlatformKind.Common)

        val jvm = module("jvm")
        jvm.setPlatformKind(TargetPlatformKind.Jvm.JVM_1_6)
        jvm.enableMultiPlatform()
        jvm.addDependency(header)

        checkHighlightingInAllFiles()
    }
}