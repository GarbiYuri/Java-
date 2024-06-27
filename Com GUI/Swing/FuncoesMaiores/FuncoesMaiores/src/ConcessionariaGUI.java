import javax.swing.*;
import java.awt.*;

public class ConcessionariaGUI extends JFrame {
    private Concessionaria concessionaria;
    private JTextField txtCarromarca, txtCarromode, txtCarrochassi, txtcarrofabri, txtcarropreco;
    private JTextField txtUserName, txtUserIdade, txtUserNmrHabi, txtDin;
    private JTextField txtCartid, txtCartquanti;
    private JTextArea txtAreaDisplay;
    private JButton btnAddUser, btnRemoveUser, btnShowClientes;
    private JButton btnAddCarro, btnShowCarro, btnRemoveCarro;
    private JButton btnAddCart, btnRemoveCart, btnAddDinheiroCart, btnRemoveDinheiroCart, btnLimpar;

    public ConcessionariaGUI() {
        concessionaria = new Concessionaria();
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Sistema de Gerenciamento de Concessionária");
        setSize(800, 600);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createCarroPanel();
        createDisplayPanel();
        createControlPanel();
        createUserPanel();
        createCartPanel();

        pack();
        setVisible(true);
    }

    private void createCarroPanel() {
        JPanel panel = new JPanel(new GridLayout(7, 2));
        panel.add(new JLabel("Marca Carro:"));
        txtCarromarca = new JTextField(20);
        panel.add(txtCarromarca);

        panel.add(new JLabel("Modelo Carro: "));
        txtCarromode = new JTextField(20);
        panel.add(txtCarromode);

        panel.add(new JLabel("Número Chassi:"));
        txtCarrochassi = new JTextField(20);
        panel.add(txtCarrochassi);

        panel.add(new JLabel("Ano Fabricação:"));
        txtcarrofabri = new JTextField(20);
        panel.add(txtcarrofabri);

        panel.add(new JLabel("Preço do Carro:"));
        txtcarropreco = new JTextField(20);
        panel.add(txtcarropreco);

        btnAddCarro = new JButton("Adicionar Carro");
        btnAddCarro.addActionListener(e -> addCarro());
        panel.add(btnAddCarro);

        btnRemoveCarro = new JButton("Remover Carro");
        btnRemoveCarro.addActionListener(e -> removeCarro());
        panel.add(btnRemoveCarro);

        add(panel, BorderLayout.NORTH);
    }

    private void createUserPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Nome do Usuário:"));
        txtUserName = new JTextField(20);
        panel.add(txtUserName);

        panel.add(new JLabel("Idade: "));
        txtUserIdade = new JTextField(20);
        panel.add(txtUserIdade);

        panel.add(new JLabel("Número Habilitação:"));
        txtUserNmrHabi = new JTextField(20);
        panel.add(txtUserNmrHabi);

        panel.add(new JLabel("Id da Carteira:"));
        txtDin = new JTextField(20);
        panel.add(txtDin);

        btnAddUser = new JButton("Adicionar Usuário");
        btnAddUser.addActionListener(e -> addUser());
        panel.add(btnAddUser);

        btnRemoveUser = new JButton("Remover Usuário");
        btnRemoveUser.addActionListener(e -> removeUser());
        panel.add(btnRemoveUser);

        add(panel, BorderLayout.WEST);
    }

    private void createCartPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Id:"));
        txtCartid = new JTextField(20);
        panel.add(txtCartid);

        panel.add(new JLabel("Dinheiro Inicial:"));
        txtCartquanti = new JTextField(20);
        panel.add(txtCartquanti);

        btnAddCart = new JButton("Adicionar Carteira");
        btnAddCart.addActionListener(e -> addCart());
        panel.add(btnAddCart);

        btnRemoveCart = new JButton("Remover Carteira");
        btnRemoveCart.addActionListener(e -> removeCart());
        panel.add(btnRemoveCart);

        btnAddDinheiroCart = new JButton("Adicionar Dinheiro");
        btnAddDinheiroCart.addActionListener(e -> addMoney());
        panel.add(btnAddDinheiroCart);

        btnRemoveDinheiroCart = new JButton("Remover Quantia");
        btnRemoveDinheiroCart.addActionListener(e -> removeMoney());
        panel.add(btnRemoveDinheiroCart);

        add(panel, BorderLayout.EAST);
    }

    private void createControlPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 4));

        btnLimpar = new JButton("Limpar Área");
        btnLimpar.addActionListener(e -> {
            txtAreaDisplay.setText("");
        });
        panel.add(btnLimpar);

        btnShowCarro = new JButton("Mostrar Carros");
        btnShowCarro.addActionListener(e -> showCarros());
        panel.add(btnShowCarro);

        JButton btnComprarCarro = new JButton("Comprar Carro");
        btnComprarCarro.addActionListener(e -> comprarCarro());
        panel.add(btnComprarCarro);

        btnShowClientes = new JButton("Mostrar Clientes");
        btnShowClientes.addActionListener(e -> showClientes());
        panel.add(btnShowClientes);

        add(panel, BorderLayout.SOUTH);
    }
    private void comprarCarro(){
    String nomeCliente = JOptionPane.showInputDialog(this, "Digite o nome do Cliente:");
    int chassic = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite o Chassi do Carro:"));

        Cliente cliente = concessionaria.findClienteByNome(nomeCliente);
        if (cliente != null) {
        if (concessionaria.comprarCarro(cliente, chassic)) {
            txtAreaDisplay.append("Carro comprado com sucesso!\n");
        } else {
            txtAreaDisplay.append("Falha na compra do carro. Verifique o chassi e saldo do cliente.\n");
        }
    } else {
        txtAreaDisplay.append("Cliente não encontrado.\n");
    }
}
    private void addCarro() {
        try {
            String marca = txtCarromarca.getText();
            String modelo = txtCarromode.getText();
            int chassi = Integer.parseInt(txtCarrochassi.getText());
            int anoFabricacao = Integer.parseInt(txtcarrofabri.getText());
            double preco = Double.parseDouble(txtcarropreco.getText());

            if (concessionaria.isChassiExists(chassi)) {
                txtAreaDisplay.append("Chassi já cadastrado, Carro não adicionado!\n");
            } else {
                concessionaria.cadastrarCarro(new Carro(marca, modelo, anoFabricacao, chassi, preco));
                txtAreaDisplay.append("Carro: " + modelo + " Cadastrado com sucesso!!\n");
            }

            clearCarroFields();
        } catch (NumberFormatException e) {
            txtAreaDisplay.append("Formato Inválido\n");
        }
    }

    private void removeCarro() {
        int chassi = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite o Chassi do Carro:"));
        Carro carro = concessionaria.findCarroByChassi(chassi);
        if (carro != null) {
            concessionaria.removerCarro(carro);
            txtAreaDisplay.append("Carro removido \n");
        } else {
            txtAreaDisplay.append("Chassi não encontrado: " + chassi + "\n");
        }
    }

    private void showCarros() {
        txtAreaDisplay.append("Carros Disponíveis: \n");
        for (Carro carro : concessionaria.getCarros()) {
            txtAreaDisplay.append("Modelo: " + carro.getModelo() + ": \n" +
                    "Fabricado no ano: " + carro.getDataFabricacao() + " \n" +
                    "Da marca: " + carro.getMarca() + " \n" +
                    "Chassi: " + carro.getChassi() + " \n" +
                    "e preço: " + carro.getPreco());
            txtAreaDisplay.append("\n________________________________\n");
        }
    }

    private void showClientes() {
        txtAreaDisplay.append("Clientes Disponíveis: \n");
        for (Cliente cliente : concessionaria.getClientes()) {
            txtAreaDisplay.append("Nome: " + cliente.getNome() +
                    " \n Idade: " + cliente.getIdade() +
                    " \n id Carteira: " + cliente.getCarteira().getIdcart() +
                    " \n Número Habilitação: " + cliente.getNumeroHabilitacao() +
                    " \n Dinheiro Na conta: " + cliente.puxarCarteira());
            txtAreaDisplay.append("\n________________________________\n");
        }
    }

    private void addUser() {
        try {
            String nome = txtUserName.getText();
            int idade = Integer.parseInt(txtUserIdade.getText());
            int nmrhabi = Integer.parseInt(txtUserNmrHabi.getText());
            int carteiraId = Integer.parseInt(txtDin.getText());

            Carteira carteira = concessionaria.findCarteiraById(carteiraId);
            if (carteira != null) {
                Cliente novoCliente = new Cliente(nome, idade, nmrhabi, carteiraId, carteira);
                concessionaria.cadastrarCliente(novoCliente);
                txtAreaDisplay.append("Cliente: " + nome + " Cadastrado com sucesso!!\n");
            } else {
                txtAreaDisplay.append("Id de Carteira não encontrado!!\n");
            }

            clearUserFields();
        } catch (NumberFormatException e) {
            txtAreaDisplay.append("Formato Inválido\n");
        }
    }

    private void removeUser() {
        String nome = JOptionPane.showInputDialog(this, "Digite o Nome do Usuário:");
        Cliente cliente = concessionaria.findClienteByNome(nome);
        if (cliente != null) {
            concessionaria.removerCliente(cliente);
            txtAreaDisplay.append("Cliente Removido: " + nome + "\n");
        } else {
            txtAreaDisplay.append("Cliente não encontrado: " + nome + "\n");
        }
    }

    private void addCart() {
        try {
            int id = Integer.parseInt(txtCartid.getText());
            double quantia = Double.parseDouble(txtCartquanti.getText());

            if (concessionaria.isCarteiraExists(id)) {
                txtAreaDisplay.append("Id já cadastrado, Carteira não adicionada!\n");
            } else {
                concessionaria.cadastrarCarteira(new Carteira(id, quantia));
                txtAreaDisplay.append("Carteira id: " + id + " Cadastrado com sucesso!!\n");
            }

            clearCartFields();
        } catch (NumberFormatException e) {
            txtAreaDisplay.append("Formato Inválido!!");
        }
    }

    private void removeCart() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite o id da Carteira:"));
        Carteira carteira = concessionaria.findCarteiraById(id);
        if (carteira != null) {
            if (concessionaria.isCarteiraSincronizada(id)) {
                txtAreaDisplay.append("Carteira está Sincronizada a um Usuário!\n");
            } else {
                concessionaria.removerCarteira(carteira);
                txtAreaDisplay.append("Carteira Removida: " + id + "\n");
            }
        } else {
            txtAreaDisplay.append("Id não encontrado: " + id + "\n");
        }
    }

    private void addMoney() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite o id da Carteira:"));
        double quantia = Double.parseDouble(JOptionPane.showInputDialog(this, "Digite a quantia a adicionar:"));
        try {
            Carteira carteira = concessionaria.findCarteiraById(id);
            if (carteira != null) {
                carteira.colocarmais(id, quantia);
                txtAreaDisplay.append("Dinheiro adicionado à carteira id: " + id + "\n");
            } else {
                txtAreaDisplay.append("Carteira não encontrada!\n");
            }
        } catch (NumberFormatException e) {
            txtAreaDisplay.append("Formato Inválido");
        }
    }

    private void removeMoney() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite o id da Carteira:"));
        double quantia = Double.parseDouble(JOptionPane.showInputDialog(this, "Digite a quantia a remover:"));
        try {
            Carteira carteira = concessionaria.findCarteiraById(id);
            if (carteira != null) {
                if (carteira.getQuantidadecart() >= quantia) {
                    carteira.setQuantidadecart(carteira.getQuantidadecart() - quantia);
                    txtAreaDisplay.append("Dinheiro removido da carteira id: " + id + "\n");
                } else {
                    txtAreaDisplay.append("Quantia insuficiente na carteira!\n");
                }
            } else {
                txtAreaDisplay.append("Carteira não encontrada!\n");
            }
        } catch (NumberFormatException e) {
            txtAreaDisplay.append("Formato Inválido");
        }
    }

    private void createDisplayPanel() {
        txtAreaDisplay = new JTextArea(10, 30);
        txtAreaDisplay.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtAreaDisplay);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void clearCarroFields() {
        txtCarromarca.setText("");
        txtCarromode.setText("");
        txtcarrofabri.setText("");
        txtcarropreco.setText("");
        txtCarrochassi.setText("");
    }

    private void clearUserFields() {
        txtUserName.setText("");
        txtUserIdade.setText("");
        txtUserNmrHabi.setText("");
        txtDin.setText("");
    }

    private void clearCartFields() {
        txtCartid.setText("");
        txtCartquanti.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ConcessionariaGUI::new);
    }
}