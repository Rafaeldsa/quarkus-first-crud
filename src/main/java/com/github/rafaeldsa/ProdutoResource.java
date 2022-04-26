package com.github.rafaeldsa;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @GET
    public List<Produto> buscaTodosProdutos() {
        return Produto.listAll();
    }

    @POST
    @Transactional
    public void buscaTodosProdutos(CadastrarProdutoDTO dto) {
        Produto p = new Produto();
        p.setNome(dto.getNome());
        p.setValor(dto.getValor());

        p.persist();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public void buscaTodosProdutos(@PathParam("id") Long id, CadastrarProdutoDTO dto) {

        Optional<Produto> produtoOp = Produto.findByIdOptional(id);

        if(produtoOp.isPresent()) {
            Produto produto = produtoOp.get();
            produto.setNome(dto.getNome());
            produto.setValor(dto.getValor());

            produto.persist();
        } else {
            throw new NotFoundException();
        }

    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void buscaTodosProdutos(@PathParam("id") Long id) {

        Optional<Produto> produtoOp = Produto.findByIdOptional(id);

        produtoOp.ifPresentOrElse(Produto::delete, () -> {
            throw new NotFoundException();
        });
    }
}
