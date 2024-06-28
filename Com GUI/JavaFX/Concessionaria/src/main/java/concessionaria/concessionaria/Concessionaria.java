package concessionaria.concessionaria;

import java.util.ArrayList;
import java.util.List;

public class Concessionaria {

    // Listas para armazenar carros, clientes e carteiras da concessionária
    private final List<Cliente> clientes;
    private final List<Carro> carros;
    private final List<Carteira> carteiras;

    // Construtor da classe Concessionaria
    public Concessionaria() {
        this.carros = new ArrayList<>(); // Inicializa a lista de carros
        this.clientes = new ArrayList<>(); // Inicializa a lista de clientes
        this.carteiras = new ArrayList<>(); // Inicializa a lista de carteiras
    }

    // Métodos para retornar listas imutáveis de carros e clientes
    public List<Carro> getCarros() {
        return carros;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    // Métodos para cadastrar e remover clientes, carros e carteiras

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente); // Adiciona um cliente à lista de clientes
    }

    public void removerCliente(Cliente cliente) {
        clientes.remove(cliente); // Remove um cliente da lista de clientes
    }

    public void cadastrarCarro(Carro carro) {
        carros.add(carro); // Adiciona um carro à lista de carros
    }

    public void removerCarro(Carro carro) {
        carros.remove(carro); // Remove um carro da lista de carros
    }

    public void cadastrarCarteira(Carteira carteira) {
        carteiras.add(carteira); // Adiciona uma carteira à lista de carteiras
    }

    public void removerCarteira(Carteira carteira) {
        carteiras.remove(carteira); // Remove uma carteira da lista de carteiras
    }

    // Verifica se um chassi de carro já existe na lista de carros
    public boolean isChassiExists(int chassi) {
        for (Carro carro : carros) {
            if (carro.getChassi() == chassi) {
                return true;
            }
        }
        return false;
    }

    // Encontra um carro pelo número de chassi na lista de carros
    public Carro findCarroByChassi(int chassi) {
        for (Carro carro : carros) {
            if (carro.getChassi() == chassi) {
                return carro;
            }
        }
        return null;
    }

    // Encontra um cliente pelo nome na lista de clientes
    public Cliente findClienteByNome(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                return cliente;
            }
        }
        return null;
    }

    // Encontra uma carteira pelo ID na lista de carteiras
    public Carteira findCarteiraById(int id) {
        for (Carteira carteira : carteiras) {
            if (carteira.getIdcart() == id) {
                return carteira;
            }
        }
        return null;
    }

    // Verifica se uma carteira com um determinado ID existe na lista de carteiras
    public boolean isCarteiraExists(int id) {
        for (Carteira carteira : carteiras) {
            if (carteira.getIdcart() == id) {
                return true;
            }
        }
        return false;
    }

    // Verifica se uma carteira com um determinado ID está sincronizada com um cliente
    public boolean isCarteiraSincronizada(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCarteira() == id) {
                return true;
            }
        }
        return false;
    }

    // Realiza a compra de um carro por um cliente
    public boolean comprarCarro(Cliente cliente, int chassi) {
        Carro carro = findCarroByChassi(chassi); // Encontra o carro pelo chassi
        if (carro != null) {
            double precoCarro = carro.getPreco(); // Obtém o preço do carro
            if (cliente.puxarCarteira() >= precoCarro) { // Verifica se o cliente tem saldo suficiente na carteira
                cliente.getCarteira().setQuantidadecart(cliente.puxarCarteira() - precoCarro); // Deduz o valor do carro da carteira do cliente
                carros.remove(carro); // Remove o carro da lista de carros da concessionária
                return true; // Retorna true se a compra foi realizada com sucesso
            }
        }
        return false; // Retorna false se a compra não foi realizada
    }
}
