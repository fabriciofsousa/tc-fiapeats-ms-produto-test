package br.com.fiap.fiapeats.usecases.pagamento;

import br.com.fiap.fiapeats.domain.entities.Cliente;
import br.com.fiap.fiapeats.domain.entities.Pagamento;
import br.com.fiap.fiapeats.usecases.dtos.CriarClienteDTO;
import br.com.fiap.fiapeats.usecases.dtos.CriarPagamentoDTO;
import br.com.fiap.fiapeats.usecases.exceptions.ClienteExistenteException;
import br.com.fiap.fiapeats.usecases.exceptions.NotFoundException;
import br.com.fiap.fiapeats.usecases.interfaces.in.cliente.CriarClienteUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.in.pagamento.CriarPagamentoUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.out.cliente.ClienteRepositoryGateway;
import br.com.fiap.fiapeats.usecases.interfaces.out.pagamento.PagamentoGateway;
import br.com.fiap.fiapeats.usecases.interfaces.out.pedido.PedidoRepositoryGateway;
import br.com.fiap.fiapeats.usecases.interfaces.out.produto.ProdutoRepositoryGateway;

public class CriarPagamentoUseCaseImpl implements CriarPagamentoUseCase {

    private final PedidoRepositoryGateway pedidoRepositoryGateway;

    private PagamentoGateway pagamentoGateway;

    public CriarPagamentoUseCaseImpl(PedidoRepositoryGateway pedidoRepositoryGateway,
                                     PagamentoGateway pagamentoGateway) {
        this.pedidoRepositoryGateway = pedidoRepositoryGateway;
        this.pagamentoGateway = pagamentoGateway;
    }

    @Override
    public Pagamento criar(CriarPagamentoDTO criarPagamentoDTO) {
        var pedido = pedidoRepositoryGateway.consultarPedidoPorId(criarPagamentoDTO.getIdPedido());
        if(pedido == null){
            throw new NotFoundException("Id pedido não encontrado");
        }

        var pedidoCriado = pagamentoGateway.criar(pedido, new Pagamento(criarPagamentoDTO.getIdPedido(), criarPagamentoDTO.getUrlNotificacao(), null));

        return new Pagamento(criarPagamentoDTO.getIdPedido(), criarPagamentoDTO.getUrlNotificacao(), pedidoCriado.getCodigoQR());
    }
}
