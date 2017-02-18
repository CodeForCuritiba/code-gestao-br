package org.openbrazil.gestao.controller

import org.helianto.root.AuthorityExtractor
import org.openbrazil.gestao.Document
import org.openbrazil.gestao.service.DocumentService
import org.springframework.security.oauth2.provider.OAuth2Authentication
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(Array("/api/document", "/document"))
class DocumentController(service: DocumentService) extends AuthorityExtractor {

  /**
    * GET /api/document/?page=
    *
    * @param principal authorized principal
    * @param page page number
    * @return list of documents from an entity
    */
  @GetMapping
  def getPage(implicit principal: OAuth2Authentication, @RequestParam(defaultValue="0") page: Int=0) =
    service.pages(_entityId, page)

  /**
    * GET /api/document/?documentId=
    *
    * @param principal authorized principal
    * @param documentId document id
    * @return a document
    */
  @GetMapping(params = Array("documentId"))
  def getOne(implicit principal: OAuth2Authentication, @RequestParam documentId: String) = service.one(documentId)

  /**
    * POST /api/document/?entityId=
    *
    * @param principal authorized principal
    * @param entityId entity id
    * @return a new document
    */
  @PostMapping(params = Array("entityId"))
  def postNew(implicit principal: OAuth2Authentication, @RequestParam entityId: String) = new Document(entityId)

  /**
    * PUT /api/document
    *
    * @param principal authorized principal
    * @param command document to save or upate
    * @return the persisted document
    */
  @PutMapping
  def putUpdate(implicit principal: OAuth2Authentication, @RequestBody command: Document) = service.saveOrUpdate(_entityId, command)

}
