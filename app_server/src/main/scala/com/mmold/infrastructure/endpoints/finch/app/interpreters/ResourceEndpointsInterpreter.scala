package com.mmold.infrastructure.endpoints.finch.app.interpreters

import com.mmold.infrastructure.endpoints.finch.app.ResourceEndpointsAlgebra

class ResourceEndpointsInterpreter extends ResourceEndpointsAlgebra {

  // def _uploadEndpoint: FinchIOEndpoint[String] = post("acceptfile" :: fileUpload("file")) { upload: FileUpload => Ok("")}

  // def getAFileBack: Endpoint[Buf] = get("getafileback" :: param("path")) {
  //    path: String =>
  //      val reader: Reader = Reader.fromFile(new File(path))
  //      Reader.readAll(reader).map(Ok)
  //  }

}
object ResourceEndpointsInterpreter {

  def apply: ResourceEndpointsInterpreter = new ResourceEndpointsInterpreter()

}