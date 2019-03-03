package com.mmold.components.templating.interpreters

import com.mmold.components.templating.interpreters.TemplatingComponentScalateInterpreter.TemplateDirectoryPath

/**
 * Scalate result config.
 *
 * @author Nick Odumo Feb 2019
 * @param templateDirectoryPath Scalate template config
 */
final case class ScalateTemplateConfig(
  templateDirectoryPath: TemplateDirectoryPath)
