package org.openbrazil.gestao

import java.util.UUID
import javax.persistence._

import scala.beans.BeanProperty

/**
  * A document is part of the Brazilian gevernment procurement process...
  */
@javax.persistence.Entity
@Table(name = "gstn_document"
  , uniqueConstraints = Array(new UniqueConstraint(columnNames = Array("entityId", "docCode"))))
class Document
( @BeanProperty @Column(length = 32)      var entityId: String) {

  @BeanProperty @Column(length = 32) @Id  var id: String = UUID.randomUUID().toString.replaceAll("-", "")
  @BeanProperty @Column(length = 32)      var docCode: String = ""
  @BeanProperty @Column(length = 256)     var docAbstract: String = ""
  @BeanProperty @Lob                      var docContent: String = ""
  @BeanProperty                           var docType: Int = 0

  def this() = this("") // empty constructor

  def merge(command: Document) = {
    docCode = command.docCode
    docAbstract = command.docAbstract
    docContent = command.docContent
    docType = command.docType
    this
  }

}
