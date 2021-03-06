/*
 * Copyright 2010-2017 JetBrains s.r.o.
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

package org.jetbrains.kotlin.noarg

import com.intellij.openapi.extensions.Extensions
import org.jetbrains.kotlin.codegen.AbstractBlackBoxCodegenTest
import org.jetbrains.kotlin.codegen.extensions.ExpressionCodegenExtension
import org.jetbrains.kotlin.diagnostics.rendering.DefaultErrorMessages
import org.jetbrains.kotlin.extensions.StorageComponentContainerContributor.Companion.registerExtension
import org.jetbrains.kotlin.noarg.AbstractBytecodeListingTestForNoArg.Companion.NOARG_ANNOTATIONS
import org.jetbrains.kotlin.noarg.diagnostic.DefaultErrorMessagesNoArg

abstract class AbstractBlackBoxCodegenTestForNoArg : AbstractBlackBoxCodegenTest() {
    override fun loadMultiFiles(files: MutableList<TestFile>) {
        Extensions.getRootArea().getExtensionPoint(DefaultErrorMessages.Extension.EP_NAME).registerExtension(DefaultErrorMessagesNoArg())

        val project = myEnvironment.project
        registerExtension(project, CliNoArgComponentContainerContributor(NOARG_ANNOTATIONS))
        ExpressionCodegenExtension.registerExtension(project, NoArgExpressionCodegenExtension())

        super.loadMultiFiles(files)
    }
}