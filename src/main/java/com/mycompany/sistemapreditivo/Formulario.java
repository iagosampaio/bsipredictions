package com.mycompany.sistemapreditivo;

import java.awt.BorderLayout; // Estabelece um contêiner, organizando e redimensionando seus componentes.
import java.io.File; // Representação abstrata de nomes de caminhos de arquivos e diretórios.
import java.util.logging.Level; // Define um conjunto de níveis de log padrão que pode ser usado para controlar a saída de log.
import java.util.logging.Logger; // Usado para registrar mensagens de log para um específico componente do sistema ou aplicativo.
import javax.swing.JFileChooser; // Fornece um mecanismo simples para o usuário escolher um arquivo.
import javax.swing.filechooser.FileNameExtensionFilter; // Implementação de filtros usando um conjunto especificado de extensões.
import weka.classifiers.bayes.NaiveBayes; // Importa o classificador NaiveBayes.
import weka.classifiers.trees.J48; // Gera uma árvore de decisão C4.5 podada ou não podada.
import weka.gui.treevisualizer.TreeVisualizer; // Exibir uma estrutura de nó no Swing.
import weka.gui.treevisualizer.PlaceNode2; // Posicionar os nós de uma árvore.
import weka.core.DenseInstance; // Manipular uma instância.
import weka.core.Instance; // Representar uma instância.
import weka.core.Instances; // Manipular um conjunto de instâncias.
import weka.core.converters.ConverterUtils; // Converter arquivos ARFF em conjuntos de dados utilizáveis pelo Weka.

public class Formulario extends javax.swing.JFrame {
    // Declaração das variáveis de Classe
    ConverterUtils.DataSource ds;
    Instances ins;
    NaiveBayes nb;
    J48 j48;

    // Construtor da classe Formulario
    public Formulario() throws Exception {
        initComponents();
        ds = null;
        ins = null;
        nb = new NaiveBayes(); // Inicializa um classificador Naive Bayes
        j48 = new J48(); // Inicializa um classificador J48 (árvore de decisão)
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTitulo = new javax.swing.JLabel();
        btnArquivo = new javax.swing.JButton();
        txtDiretorio = new javax.swing.JTextField();
        txtSexo = new javax.swing.JLabel();
        txtNaturalidade = new javax.swing.JLabel();
        txtFormaIngresso = new javax.swing.JLabel();
        txtIdadeMatricula = new javax.swing.JLabel();
        cxSexo = new javax.swing.JComboBox<>();
        cxNaturalidade = new javax.swing.JComboBox<>();
        cxFormaIngresso = new javax.swing.JComboBox<>();
        cxIdadeMatricula = new javax.swing.JComboBox<>();
        btnClassificar = new javax.swing.JButton();
        jlBayes = new javax.swing.JLabel();
        jlSim_nb = new javax.swing.JLabel();
        jlNao_nb = new javax.swing.JLabel();
        jlSim_j48 = new javax.swing.JLabel();
        jlNao_j48 = new javax.swing.JLabel();
        jlJ48 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        imgArvore = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Preditivo - Java + Bibliotecas Weka");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1100, 680));
        setResizable(false);

        txtTitulo.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        txtTitulo.setText("CÁLCULO DE PROBABILIDADE DE REINTEGRAÇÃO: ");

        btnArquivo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnArquivo.setText("Escolher Arquivo");
        btnArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArquivoActionPerformed(evt);
            }
        });

        txtDiretorio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtSexo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtSexo.setText("Sexo:");

        txtNaturalidade.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtNaturalidade.setText("Naturalidade:");

        txtFormaIngresso.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtFormaIngresso.setText("Forma de Ingresso:");

        txtIdadeMatricula.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtIdadeMatricula.setText("Idade na Matrícula:");

        cxSexo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "m", "f" }));

        cxNaturalidade.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cxNaturalidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "vca", "200km", "outros" }));

        cxFormaIngresso.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cxFormaIngresso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ampla", "cota", "outros" }));

        cxIdadeMatricula.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cxIdadeMatricula.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "16-21", "22-26", "27-30", "31_mais" }));

        btnClassificar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnClassificar.setText("Classificar");
        btnClassificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClassificarActionPerformed(evt);
            }
        });

        jlBayes.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlBayes.setText("Naive Bayes");

        jlSim_nb.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlSim_nb.setForeground(new java.awt.Color(51, 204, 0));
        jlSim_nb.setText("SIM");

        jlNao_nb.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlNao_nb.setForeground(new java.awt.Color(255, 0, 0));
        jlNao_nb.setText("NÃO");

        jlSim_j48.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlSim_j48.setForeground(new java.awt.Color(51, 204, 0));
        jlSim_j48.setText("SIM");

        jlNao_j48.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlNao_j48.setForeground(new java.awt.Color(255, 0, 0));
        jlNao_j48.setText("NÃO");

        jlJ48.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlJ48.setText("J48");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Visualização da Árvore de Decisão (J48):");

        imgArvore.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout imgArvoreLayout = new javax.swing.GroupLayout(imgArvore);
        imgArvore.setLayout(imgArvoreLayout);
        imgArvoreLayout.setHorizontalGroup(
            imgArvoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        imgArvoreLayout.setVerticalGroup(
            imgArvoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(imgArvore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(908, 908, 908))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(txtTitulo)
                        .addGap(196, 196, 196)
                        .addComponent(btnClassificar, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(txtNaturalidade)
                                        .addGap(87, 87, 87)
                                        .addComponent(txtFormaIngresso))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(73, 73, 73)
                                        .addComponent(cxNaturalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(132, 132, 132)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(cxFormaIngresso, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnArquivo)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtDiretorio, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(cxIdadeMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtIdadeMatricula))))
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlBayes, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addComponent(jlSim_nb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlNao_nb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlJ48, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlSim_j48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlNao_j48, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))))
                .addGap(684, 684, 684))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTitulo)
                    .addComponent(btnClassificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiretorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnArquivo)
                    .addComponent(jlBayes)
                    .addComponent(jlJ48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSexo)
                            .addComponent(txtNaturalidade)
                            .addComponent(txtFormaIngresso)
                            .addComponent(txtIdadeMatricula)))
                    .addComponent(jlSim_j48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlSim_nb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cxNaturalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cxFormaIngresso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cxIdadeMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlNao_nb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlNao_j48, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imgArvore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArquivoActionPerformed
        // Cria uma instância de JFileChooser para permitir ao usuário selecionar um arquivo
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Procurar arquivo"); // Define o título da janela de diálogo
        // Define o modo de seleção para permitir apenas a seleção de arquivos
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        // Define um filtro de extensão de arquivo para mostrar apenas arquivos .arff (formato Weka)
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivo", "arff");
        
        fileChooser.setFileFilter(filter); // Aplica o filtro ao seletor de arquivo
        // Abre a janela de diálogo para permitir ao usuário escolher um arquivo
        int retorno = fileChooser.showOpenDialog(this);
        // Verifica se o usuário selecionou um arquivo com sucesso
        if(retorno == JFileChooser.APPROVE_OPTION){           
            File file = fileChooser.getSelectedFile();// Obtém o arquivo selecionado pelo usuário
            String filePath = file.getPath(); // Obtém o caminho absoluto do arquivo
            
            try {
                // Cria uma instância de DataSource a partir do caminho do arquivo
                ds = new ConverterUtils.DataSource(filePath);
                // Carrega os dados do arquivo para um conjunto de dados (Instances)
                ins = ds.getDataSet();
                   
        } catch (Exception ex) {
            // Em caso de exceção durante o carregamento do arquivo, registra a exceção no logger
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        }
                // Define o caminho do arquivo selecionado no JTextField txtDiretorio
                txtDiretorio.setText(filePath);
            } 
    }//GEN-LAST:event_btnArquivoActionPerformed

    private void btnClassificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClassificarActionPerformed
    try {
            // Obter os valores dos atributos selecionados pelo usuário
            String sexo = (String) cxSexo.getSelectedItem();
            String naturalidade = (String) cxNaturalidade.getSelectedItem();
            String forma_ingresso = (String) cxFormaIngresso.getSelectedItem();          
            String idade_matricula = (String) cxIdadeMatricula.getSelectedItem();
            
            // Configurar o conjunto de dados ('ins') para classificação
            ins.setClassIndex(4); // Define o índice do atributo classe
            try {
                // Construir os modelos de classificação Naive Bayes e J48
                nb.buildClassifier(ins);
                j48.buildClassifier(ins);
                
                // Criar uma nova instância ('novo') com os valores dos atributos fornecidos pelo usuário
                Instance novo = new DenseInstance(5); // 5 é o número de atributos na instância
                novo.setDataset(ins);
                novo.setValue(0, sexo);
                novo.setValue(1, naturalidade);
                novo.setValue(2, forma_ingresso);
                novo.setValue(3, idade_matricula);

                // Classificar a instância usando Naive Bayes e exibir as probabilidades
                double prob_nb[] = nb.distributionForInstance(novo);
                double prob_nao_nb_percent = prob_nb[0] * 100;
                double prob_sim_nb_percent = prob_nb[1] * 100;
                jlNao_nb.setText("NÃO: " + String.format("%.2f%%", prob_nao_nb_percent));
                jlSim_nb.setText("SIM: " + String.format("%.2f%%", prob_sim_nb_percent));

                // Classificar a instância usando J48 (árvore de decisão) e exibir o resultado
                double predictedClass = j48.classifyInstance(novo);
                String predictedClassLabel = ins.classAttribute().value((int) predictedClass);
                jlNao_j48.setText("NÃO: " + (predictedClassLabel.equals("nao") ? "1.0" : "0.0"));
                jlSim_j48.setText("SIM: " + (predictedClassLabel.equals("sim") ? "1.0" : "0.0"));
                
                // Criar uma visualização da árvore de decisão gerada pelo J48
                TreeVisualizer treeVisualizer = new TreeVisualizer(null, j48.graph(), new PlaceNode2());
                
                // Configurar a visualização da árvore de decisão
                treeVisualizer.setSize(imgArvore.getSize());
                treeVisualizer.fitToScreen();
                
                // Adicionar a visualização da árvore ao JPanel 'imgArvore' 
                imgArvore.setLayout(new BorderLayout());
                imgArvore.add(treeVisualizer, BorderLayout.CENTER);
         
                // Tornar os resultados e a visualização visíveis na interface
                jlBayes.setVisible(true);
                jlNao_nb.setVisible(true);
                jlSim_nb.setVisible(true);
                jlJ48.setVisible(true);
                jlNao_j48.setVisible(true);
                jlSim_j48.setVisible(true);
                                
            } catch (Exception ex) {
                Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnClassificarActionPerformed

    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Formulario().setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArquivo;
    private javax.swing.JButton btnClassificar;
    private javax.swing.JComboBox<String> cxFormaIngresso;
    private javax.swing.JComboBox<String> cxIdadeMatricula;
    private javax.swing.JComboBox<String> cxNaturalidade;
    private javax.swing.JComboBox<String> cxSexo;
    private javax.swing.JPanel imgArvore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jlBayes;
    private javax.swing.JLabel jlJ48;
    private javax.swing.JLabel jlNao_j48;
    private javax.swing.JLabel jlNao_nb;
    private javax.swing.JLabel jlSim_j48;
    private javax.swing.JLabel jlSim_nb;
    private javax.swing.JTextField txtDiretorio;
    private javax.swing.JLabel txtFormaIngresso;
    private javax.swing.JLabel txtIdadeMatricula;
    private javax.swing.JLabel txtNaturalidade;
    private javax.swing.JLabel txtSexo;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
