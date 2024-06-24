
import javax.swing.*;
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

        pack();
        setVisible(true);
    }

    private void createProductPanel() {
        JPanel panel = new JPanel(new GridLayout(7, 2));
        panel.add(new JLabel("Produto:"));
        txtProduct = new JTextField(20);

        panel.add(txtProduct);
        panel.add(new JLabel("Quantidade:"));
        txtProductQuantidade = new JTextField(20);
        panel.add(txtProductQuantidade);
        panel.add(new JLabel("Preço:"));
        txtProductPreco = new JTextField(20);
        panel.add(txtProductPreco);
        btnAddProduct = new JButton("Adicionar Produto");
        btnAddProduct.addActionListener(e -> addProduct());
        panel.add(btnAddProduct);

        btnAddToCart = new JButton("Adicionar ao Carrinho");
        btnAddToCart.addActionListener(e -> addToCart());
        panel.add(btnAddToCart);

        btnRemoveProduct = new JButton("Remover Produto");
        btnRemoveProduct.addActionListener(e -> removeProductFromMarket());
        panel.add(btnRemoveProduct);

        btnRemoveFromCart = new JButton("Remover do Carrinho");
        btnRemoveFromCart.addActionListener(e -> removeFromCart());
        panel.add(btnRemoveFromCart);

        add(panel, BorderLayout.NORTH);
    }

    private void createUserPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Nome do Usuário:"));
        txtUserName = new JTextField(20);
        panel.add(txtUserName);
        btnAddUser = new JButton("Adicionar Usuário");
        btnAddUser.addActionListener(e -> addUser());
        panel.add(btnAddUser);

        btnRemoveUser = new JButton("Remover Usuário");
        btnRemoveUser.addActionListener(e -> removeUser());
        panel.add(btnRemoveUser);

        add(panel, BorderLayout.WEST);
    }

    private void createDisplayPanel() {
        txtAreaDisplay = new JTextArea(10, 30);
        txtAreaDisplay.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtAreaDisplay);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void createControlPanel() {
        JPanel panel = new JPanel();


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
            supermarket.adicionarProduto(new Produto(nome, preco, quantidade));
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
            txtAreaDisplay.append(cliente.getNome() + " \n");
        }

    }

    private void showProductsInCart() {
        double geral = 0;
        txtAreaDisplay.setText("Produtos no Carrinho:\n");
        for (Produto produto : supermarket.getCarrinho().getProdutos()) {
            geral += produto.getPreco() * produto.getQuantidade();
            txtAreaDisplay.append(produto.getNome() + ", Quantidade: R$" + produto.getQuantidade() + ", Preço: R$" + produto.getPreco() + " \n");
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
            if (produtoParaAdicionar.getQuantidade() >= quantidade) {
                Produto produtoCarrinho = new Produto(produtoParaAdicionar.getNome(), produtoParaAdicionar.getPreco(), quantidade);
                supermarket.getCarrinho().adicionarProduto(produtoCarrinho);
                produtoParaAdicionar.emprestar(quantidade);
                txtAreaDisplay.append("Produto adicionado ao carrinho: " + nomeProduto + ", Quantidade: " + quantidade + "\n");
            } else {
                txtAreaDisplay.append("Quantidade insuficiente em estoque para " + nomeProduto + "\n");
            }
        } else {
            txtAreaDisplay.append("Produto fora de estoque ou não encontrado: " + nomeProduto + "\n");
        }
    }

    public void comprar() {
        String nomeUsuario = JOptionPane.showInputDialog(this, "Digite o nome do usuário:");
        Cliente usuario = supermarket.getNomeCliente(nomeUsuario);

        if (usuario == null) {
            txtAreaDisplay.append("\nUsuário não encontrado: " + nomeUsuario + "\n");
            return;
        }

        String pagamento = JOptionPane.showInputDialog(this, "Qual a forma de pagamento:(1 = débito; 2 = crédito; 3 = dinheiro)");
        int pagamentolog;
        try {
            pagamentolog = Integer.parseInt(pagamento);
        } catch (NumberFormatException e) {
            txtAreaDisplay.append("Forma de pagamento inválida.\n");
            return;
        }

        switch (pagamentolog) {
            case 1:
                txtAreaDisplay.append("\n" + nomeUsuario + ", pagamento de: R$" + txtgeral + " no débito efetuado!\n");
                break;
            case 2:
                txtAreaDisplay.append("\n" + nomeUsuario + ", pagamento de: R$" + txtgeral + " no crédito efetuado!\n");
                break;
            case 3:
                String troco = JOptionPane.showInputDialog(this, "Quantia recebida:");
                double trocoqtd;
                try {
                    trocoqtd = Double.parseDouble(troco);
                    if (trocoqtd < txtgeral) {
                        txtAreaDisplay.append("\nQuantia insuficiente. Pagamento não realizado.\n");
                        return;
                    }
                    txtAreaDisplay.append("\n" + nomeUsuario + ", pagamento de: R$" + txtgeral + " em dinheiro efetuado! Troco: " + (trocoqtd - txtgeral) + "\n");
                } catch (NumberFormatException e) {
                    txtAreaDisplay.append("\nQuantia inválida.\n");
                    return;
                }
                break;
            default:
                txtAreaDisplay.append("\nForma de pagamento inválida.\n");
                return;
        }

        supermarket.getCarrinho().esvaziar();

    }



    private void removeFromCart() {
        String nomeProduto = JOptionPane.showInputDialog(this, "Digite o nome do produto para remover do carrinho:");
        Optional<Produto> produtoParaRemoverOpt = supermarket.getCarrinho().getProdutos().stream()
                .filter(produto -> produto.getNome().equals(nomeProduto))
                .findFirst();

        if (produtoParaRemoverOpt.isPresent()) {
            Produto produtoParaRemover = produtoParaRemoverOpt.get();
            String quantidadeStr = JOptionPane.showInputDialog(this, "Digite a quantidade para remover do carrinho:");
            int quantidade;
            try {
                quantidade = Integer.parseInt(quantidadeStr);
            } catch (NumberFormatException e) {
                txtAreaDisplay.append("Quantidade inválida.\n");
                return;
            }
            if (produtoParaRemover.getQuantidade() >= quantidade) {
                produtoParaRemover.emprestar(quantidade);
                if (produtoParaRemover.getQuantidade() == 0) {
                    supermarket.getCarrinho().removerProduto(produtoParaRemover);
                }
                for (Produto produto : supermarket.getProdutos()) {
                    if (produto.getNome().equals(produtoParaRemover.getNome())) {
                        produto.devolver(quantidade);
                        break;
                    }
                }
                txtAreaDisplay.append("Produto removido do carrinho: " + nomeProduto + ", Quantidade: " + quantidade + "\n");
            } else {
                txtAreaDisplay.append("Quantidade insuficiente no carrinho para " + nomeProduto + "\n");
            }
        } else {
            txtAreaDisplay.append("Produto não encontrado no carrinho: " + nomeProduto + "\n");
        }
    }

    private void removeUser() {
        String nomeUsuario = JOptionPane.showInputDialog(this, "Digite o nome do usuário:");
        Cliente usuarioParaRemover = null;
        for (Cliente cliente : supermarket.getClientes()) {
            if (cliente.getNome().equals(nomeUsuario)) {
                usuarioParaRemover = cliente;
                break;
            }
        }
        if (usuarioParaRemover != null) {
            supermarket.removerUsuario(usuarioParaRemover);
            txtAreaDisplay.append("Usuário removido: " + nomeUsuario + "\n");
        } else {
            txtAreaDisplay.append("Usuário não encontrado: " + nomeUsuario + "\n");
        }
    }

    private void removeProductFromMarket() {
        String nomeProduto = JOptionPane.showInputDialog(this, "Digite o nome do produto para remover:");
        Optional<Produto> produtoParaRemoverOpt = supermarket.getProdutos().stream()
                .filter(produto -> produto.getNome().equals(nomeProduto))
                .findFirst();

        if (produtoParaRemoverOpt.isPresent()) {
            Produto produtoParaRemover = produtoParaRemoverOpt.get();
            String quantidadeStr = JOptionPane.showInputDialog(this, "Digite a quantidade para remover do mercado:");
            int quantidade;
            try {
                quantidade = Integer.parseInt(quantidadeStr);
            } catch (NumberFormatException e) {
                txtAreaDisplay.append("Quantidade inválida.\n");
                return;
            }
            if (produtoParaRemover.getQuantidade() >= quantidade) {
                produtoParaRemover.emprestar(quantidade);
                if (produtoParaRemover.getQuantidade() == 0) {
                    supermarket.removerProduto(produtoParaRemover);
                }
                txtAreaDisplay.append("Produto removido do mercado: " + nomeProduto + ", Quantidade: " + quantidade + "\n");
            } else {
                txtAreaDisplay.append("Quantidade insuficiente em estoque para " + nomeProduto + "\n");
            }
        } else {
            txtAreaDisplay.append("Produto não encontrado: " + nomeProduto + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SupermarketGUI::new);
    }
}
