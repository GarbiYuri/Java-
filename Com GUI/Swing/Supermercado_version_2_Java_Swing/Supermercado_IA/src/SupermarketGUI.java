import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Optional;

public class SupermarketGUI extends JFrame {
    private Supermarket supermarket;
    private JTextField txtProduct;
    private JTextField txtProductQuantidade;
    private JTextField txtUserName;
    private JTextField txtProductPreco;
    private double txtgeral;
    private JTextArea txtAreaDisplay;
    private JButton btnAddProduct, btnAddUser, btnShowProduct, btnAddToCart, btnRemoveFromCart, btnRemoveUser, btnRemoveProduct, btnShowCart, btncomprar, btnshowclientes;

    public SupermarketGUI() {
        supermarket = new Supermarket();
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Sistema de Gerenciamento de Mercado");
        setSize(800, 600);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createProductPanel();
        createUserPanel();
        createDisplayPanel();
        createControlPanel();

        setVisible(true);
    }

    private void createProductPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new TitledBorder("Gerenciamento de Produtos"));
        panel.setBackground(Color.LIGHT_GRAY);  // Definindo cor de fundo
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel lblProduct = new JLabel("Produto:");
        lblProduct.setBackground(Color.LIGHT_GRAY);  // Definindo cor de fundo
        panel.add(lblProduct, gbc);

        gbc.gridx = 1;
        txtProduct = new JTextField(20);
        panel.add(txtProduct, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setBackground(Color.LIGHT_GRAY);  // Definindo cor de fundo
        panel.add(lblQuantidade, gbc);

        gbc.gridx = 1;
        txtProductQuantidade = new JTextField(20);
        panel.add(txtProductQuantidade, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel lblPreco = new JLabel("Preço:");
        lblPreco.setBackground(Color.LIGHT_GRAY);  // Definindo cor de fundo
        panel.add(lblPreco, gbc);

        gbc.gridx = 1;
        txtProductPreco = new JTextField(20);
        panel.add(txtProductPreco, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        btnAddProduct = new JButton("Adicionar Produto");
        btnAddProduct.addActionListener(e -> addProduct());
        panel.add(btnAddProduct, gbc);

        gbc.gridy = 4;
        btnAddToCart = new JButton("Adicionar ao Carrinho");
        btnAddToCart.addActionListener(e -> addToCart());
        panel.add(btnAddToCart, gbc);

        gbc.gridy = 5;
        btnRemoveProduct = new JButton("Remover Produto");
        btnRemoveProduct.addActionListener(e -> removeProductFromMarket());
        panel.add(btnRemoveProduct, gbc);

        gbc.gridy = 6;
        btnRemoveFromCart = new JButton("Remover do Carrinho");
        btnRemoveFromCart.addActionListener(e -> removeFromCart());
        panel.add(btnRemoveFromCart, gbc);

        add(panel, BorderLayout.WEST);
    }

    private void createUserPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new TitledBorder("Gerenciamento de Usuários"));
        panel.setBackground(Color.LIGHT_GRAY);  // Definindo cor de fundo
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel lblUserName = new JLabel("Nome do Usuário:");
        lblUserName.setBackground(Color.LIGHT_GRAY);  // Definindo cor de fundo
        panel.add(lblUserName, gbc);

        gbc.gridx = 1;
        txtUserName = new JTextField(20);
        panel.add(txtUserName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        btnAddUser = new JButton("Adicionar Usuário");
        btnAddUser.addActionListener(e -> addUser());
        panel.add(btnAddUser, gbc);

        gbc.gridy = 2;
        btnRemoveUser = new JButton("Remover Usuário");
        btnRemoveUser.addActionListener(e -> removeUser());
        panel.add(btnRemoveUser, gbc);

        add(panel, BorderLayout.EAST);
    }

    private void createDisplayPanel() {
        txtAreaDisplay = new JTextArea(20, 40);
        txtAreaDisplay.setEditable(false);
        txtAreaDisplay.setBackground(Color.WHITE);  // Definindo cor de fundo
        JScrollPane scrollPane = new JScrollPane(txtAreaDisplay);
        scrollPane.setBorder(new TitledBorder("Informações"));
        add(scrollPane, BorderLayout.CENTER);
    }

    private void createControlPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setBorder(new TitledBorder("Controles"));
        panel.setBackground(Color.LIGHT_GRAY);  // Definindo cor de fundo

        btnShowCart = new JButton("Mostrar Carrinho");
        btnShowCart.addActionListener(e -> showProductsInCart());
        panel.add(btnShowCart);

        btncomprar = new JButton("Comprar");
        btncomprar.addActionListener(e -> comprar());
        panel.add(btncomprar);

        btnShowProduct = new JButton("Mostrar Produtos");
        btnShowProduct.addActionListener(e -> showAvailableProducts());
        panel.add(btnShowProduct);

        btnshowclientes = new JButton("Mostrar Clientes");
        btnshowclientes.addActionListener(e -> showClientes());
        panel.add(btnshowclientes);

        add(panel, BorderLayout.SOUTH);
    }

    private void addProduct() {
        try {
            String nome = txtProduct.getText();
            double preco = Double.parseDouble(txtProductPreco.getText());
            int quantidade = Integer.parseInt(txtProductQuantidade.getText());
            if (nome.isEmpty() || preco <= 0 || quantidade <= 0) {
                throw new NumberFormatException();
            }
            Produto produto = new Produto(nome, preco, quantidade);
            supermarket.adicionarProduto(produto);
            txtProduct.setText("");
            txtProductPreco.setText("");
            txtProductQuantidade.setText("");
            txtAreaDisplay.append("Produto adicionado: " + nome + "\n");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addUser() {
        String name = txtUserName.getText();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um nome válido.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
            return;
        }
        supermarket.adicionarUsuario(new Cliente(name));
        txtUserName.setText("");
        txtAreaDisplay.append("Usuário adicionado: " + name + "\n");
    }

    private void showAvailableProducts() {
        txtAreaDisplay.setText("Produtos disponíveis:\n");
        for (Produto produto : supermarket.getProdutos()) {
            if (produto.getQuantidade() > 0) {
                txtAreaDisplay.append(produto.getNome() + ", Quantidade: " + produto.getQuantidade() + ", Preço: R$" + produto.getPreco() + "\n");
            }
        }
    }

    private void showClientes() {
        txtAreaDisplay.setText("Clientes na Loja:\n");
        for (Cliente cliente : supermarket.getClientes()) {
            txtAreaDisplay.append(cliente.getNome() + "\n");
        }
    }

    private void showProductsInCart() {
        double geral = 0;
        txtAreaDisplay.setText("Produtos no Carrinho:\n");
        for (Produto produto : supermarket.getCarrinho().getProdutos()) {
            geral += produto.getPreco() * produto.getQuantidade();
            txtAreaDisplay.append(produto.getNome() + ", Quantidade: " + produto.getQuantidade() + ", Preço: R$" + produto.getPreco() + "\n");
        }
        txtAreaDisplay.append("Total: R$" + geral);
        txtgeral = geral;
    }

    private void addToCart() {
        String nomeProduto = JOptionPane.showInputDialog(this, "Digite o nome do produto para adicionar ao carrinho:");
        Optional<Produto> produtoParaAdicionarOpt = supermarket.getProdutos().stream()
                .filter(produto -> produto.getNome().equals(nomeProduto) && produto.getQuantidade() > 0)
                .findFirst();

        if (produtoParaAdicionarOpt.isPresent()) {
            Produto produtoParaAdicionar = produtoParaAdicionarOpt.get();
            String quantidadeStr = JOptionPane.showInputDialog(this, "Digite a quantidade para adicionar ao carrinho:");
            int quantidade;
            try {
                quantidade = Integer.parseInt(quantidadeStr);
            } catch (NumberFormatException e) {
                txtAreaDisplay.append("Quantidade inválida.\n");
                return;
            }

            if (quantidade > 0 && quantidade <= produtoParaAdicionar.getQuantidade()) {
                Produto produtoCarrinho = new Produto(produtoParaAdicionar.getNome(), produtoParaAdicionar.getPreco(), quantidade);
                supermarket.getCarrinho().adicionarProduto(produtoCarrinho);
                produtoParaAdicionar.removerQuantidade(quantidade);
                txtAreaDisplay.append("Produto adicionado ao carrinho: " + produtoParaAdicionar.getNome() + ", Quantidade: " + quantidade + "\n");
            } else {
                txtAreaDisplay.append("Quantidade indisponível em estoque.\n");
            }
        } else {
            txtAreaDisplay.append("Produto não encontrado ou sem estoque.\n");
        }
    }

    private void removeProductFromMarket() {
        String nomeProduto = JOptionPane.showInputDialog(this, "Digite o nome do produto para remover:");
        Optional<Produto> produtoParaRemoverOpt = supermarket.getProdutos().stream()
                .filter(produto -> produto.getNome().equals(nomeProduto))
                .findFirst();

        if (produtoParaRemoverOpt.isPresent()) {
            Produto produtoParaRemover = produtoParaRemoverOpt.get();
            supermarket.removerProduto(produtoParaRemover);
            txtAreaDisplay.append("Produto removido do mercado: " + produtoParaRemover.getNome() + "\n");
        } else {
            txtAreaDisplay.append("Produto não encontrado.\n");
        }
    }

    private void removeFromCart() {
        String nomeProduto = JOptionPane.showInputDialog(this, "Digite o nome do produto para remover do carrinho:");
        Optional<Produto> produtoParaRemoverOpt = supermarket.getCarrinho().getProdutos().stream()
                .filter(produto -> produto.getNome().equals(nomeProduto))
                .findFirst();

        if (produtoParaRemoverOpt.isPresent()) {
            Produto produtoParaRemover = produtoParaRemoverOpt.get();
            supermarket.getCarrinho().removerProduto(produtoParaRemover);
            supermarket.getProdutos().stream()
                    .filter(produto -> produto.getNome().equals(produtoParaRemover.getNome()))
                    .findFirst()
                    .ifPresent(produto -> produto.adicionarQuantidade(produtoParaRemover.getQuantidade()));
            txtAreaDisplay.append("Produto removido do carrinho: " + produtoParaRemover.getNome() + "\n");
        } else {
            txtAreaDisplay.append("Produto não encontrado no carrinho.\n");
        }
    }

    private void removeUser() {
        String nomeCliente = JOptionPane.showInputDialog(this, "Digite o nome do cliente para remover:");
        Cliente clienteParaRemover = supermarket.getNomeCliente(nomeCliente);

        if (clienteParaRemover != null) {
            supermarket.removerUsuario(clienteParaRemover);
            txtAreaDisplay.append("Cliente removido: " + nomeCliente + "\n");
        } else {
            txtAreaDisplay.append("Cliente não encontrado.\n");
        }
    }

    private void comprar() {
        supermarket.getCarrinho().esvaziar();
        txtAreaDisplay.append("\n\n*** Comprado ***\n");
        txtAreaDisplay.append("Total: " + txtgeral);
        txtgeral = 0;
    }

    public static void main(String[] args) {
        new SupermarketGUI();
    }
}
