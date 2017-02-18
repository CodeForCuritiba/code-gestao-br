package org.openbrazil.gestao.repository

import org.openbrazil.gestao.Document
import org.springframework.data.domain.{Page, Pageable}
import org.springframework.data.jpa.repository.JpaRepository

trait DocumentRepository extends JpaRepository[Document, String] {

  def findByEntityId(entityId: String, page: Pageable): Page[Document]

}
