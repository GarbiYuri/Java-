import java.util.ArrayList;
import java.util.List;

public class Concessionaria {

    private final List<Cliente> clientes;
    private final List<Carro> carros;
    private final List<Carteira> carteiras;

    public Concessionaria() {
        this.carros = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.carteiras = new ArrayList<>();
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }


    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void removerCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public void cadastrarCarro(Carro carro) {
        carros.add(carro);
    }

    public void removerCarro(Carro carro) {
        carros.remove(carro);
    }

    public void cadastrarCarteira(Carteira carteira) {
        carteiras.add(carteira);
    }

    public void removerCarteira(Carteira carteira) {
        carteiras.remove(carteira);
    }

    public boolean isChassiExists(int chassi) {
        for (Carro carro : carros) {
            if (carro.getChassi() == chassi) {
                return true;
            }
        }
        return false;
    }

    public Carro findCarroByChassi(int chassi) {
        for (Carro carro : carros) {
            if (carro.getChassi() == chassi) {
                return carro;
            }
        }
        return null;
    }

    public Cliente findClienteByNome(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                return cliente;
            }
        }
        return null;
    }

    public Carteira findCarteiraById(int id) {
        for (Carteira carteira : carteiras) {
            if (carteira.getIdcart() == id) {
                return carteira;
            }
        }
        return null;
    }

    public boolean isCarteiraExists(int id) {
        for (Carteira carteira : carteiras) {
            if (carteira.getIdcart() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean isCarteiraSincronizada(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCarteira() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean comprarCarro(Cliente cliente, int chassi) {
        Carro carro = findCarroByChassi(chassi);
        if (carro != null) {
            double precoCarro = carro.getPreco();
            if (cliente.puxarCarteira() >= precoCarro) {
                cliente.getCarteira().setQuantidadecart(cliente.puxarCarteira() - precoCarro);
                carros.remove(carro);
                return true;
            }
        }
        return false;
    }
}