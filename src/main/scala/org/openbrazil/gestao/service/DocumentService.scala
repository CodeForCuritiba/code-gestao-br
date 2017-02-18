package org.openbrazil.gestao.service

import org.openbrazil.gestao.Document
import org.openbrazil.gestao.repository.DocumentRepository
import org.springframework.data.domain.{PageRequest, Sort}
import org.springframework.stereotype.Service

@Service
class DocumentService(val repository: DocumentRepository) {

  private[service] val pageSize = 10

  private[service] def page(page: Int) = new PageRequest(page, 10, Sort.Direction.ASC, "docCode")

  def pages(entityId: String, p: Int = 0) =
    repository.findByEntityId(Option(entityId).getOrElse(""), page(p))

  def one(documentId: String) = repository.findOne(Option(documentId).getOrElse(""))

  def saveOrUpdate(entityId: String, command: Document) = {
    require(Option(entityId).nonEmpty)
    require(Option(command).nonEmpty)
    repository.save(Option(repository.findOne(command.getId)).getOrElse(new Document(entityId)).merge(command))
  }

}
