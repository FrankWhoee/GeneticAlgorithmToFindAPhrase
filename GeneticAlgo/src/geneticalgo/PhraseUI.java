
package geneticalgo;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import java.awt.Event;

public class PhraseUI extends javax.swing.JFrame {
    ArrayList<Phrase> population = new ArrayList<>();
    Phrase bestPhrase = new Phrase("",0);
    int generationNum = 0;
    double avgFitness = 0;
    ArrayList<String> loadingSpinner = new ArrayList<>();
    int loadingNum = 0;
    
    public PhraseUI() {
        initComponents();
        importLoaderChoices();
        
        
    }
    
    public void importLoaderChoices(){
        choiceLoaders.add("Spinner");
        choiceLoaders.add("Bouncer");
        choiceLoaders.add("Pulse");
        choiceLoaders.add("Hands");
        choiceLoaders.add("Moons");
        choiceLoaders.add("Dots");
    }
    
    public void importLoader(String type){
        if(type.equals("Spinner")){
            loadingSpinner.add("|");
            loadingSpinner.add("/");
            loadingSpinner.add("–");
            loadingSpinner.add("\\");
        }else if(type.equals("Bouncer")){
            loadingSpinner.add("=    ");
            loadingSpinner.add(" =   ");
            loadingSpinner.add("  =  ");
            loadingSpinner.add("    =");
            loadingSpinner.add("  =  ");
            loadingSpinner.add(" =   ");
            loadingSpinner.add("=    ");
        }else if(type.equals("Pulse")){
            loadingSpinner.add("▁");
            loadingSpinner.add("▂");
            loadingSpinner.add("▃");
            loadingSpinner.add("▄");
            loadingSpinner.add("▅");
            loadingSpinner.add("▆");
            loadingSpinner.add("▇");
            loadingSpinner.add("█");
        }else if(type.equals("Hands")){
            loadingSpinner.add("👆");
            loadingSpinner.add("👈");
            loadingSpinner.add("👇");
            loadingSpinner.add("👉");
        }else if(type.equals("Moons")){
            loadingSpinner.add("🌑");
            loadingSpinner.add("🌒");
            loadingSpinner.add("🌓");
            loadingSpinner.add("🌔");
            loadingSpinner.add("🌕");
            loadingSpinner.add("🌖");
            loadingSpinner.add("🌗");
            loadingSpinner.add("🌘");
            loadingSpinner.add("🌑");
        }else{
            loadingSpinner.add(".      ");
            loadingSpinner.add("..     ");
            loadingSpinner.add("...    ");
            loadingSpinner.add("....   ");
            loadingSpinner.add(".....  ");
            loadingSpinner.add("...... ");
            loadingSpinner.add(".......");
        }
    }

    public void update(){
        textBestPhrase.setText(bestPhrase.getPhrase());
        textGen.setText(Integer.toString(generationNum));
        textPop.setText("" + population.size());
        textFitness.setText("" + avgFitness);
        listPop.removeAll();
        for(Phrase phrase: population){
            listPop.add(phrase.getPhrase());
        }
    }
    
    public void updateAVGFitness(){
        double totalFitness = 0;
        for(Phrase phrase: population){
            totalFitness += phrase.getFitness();
        }
        avgFitness = totalFitness/(double)population.size();
    }
    
    public void updateBestPhrase(){
        for(Phrase phrase: population){
            if(bestPhrase.getFitness() < phrase.getFitness()){
                bestPhrase = phrase;
            }
        }
        this.bestPhrase = bestPhrase;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        buttonRun = new javax.swing.JButton();
        textPhrase = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textMutateRate = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textStartPop = new javax.swing.JTextField();
        listPop = new java.awt.List();
        textBestPhrase = new java.awt.TextField();
        textGen = new java.awt.TextField();
        textPop = new java.awt.TextField();
        textFitness = new java.awt.TextField();
        enableCapsNum = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        choiceLoaders = new java.awt.Choice();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setText("Best Phrase");

        jLabel2.setText("Generation:");

        jLabel3.setText("Average Fitness:");

        jLabel4.setText("Population Size:");

        buttonRun.setText("Run");
        buttonRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRunActionPerformed(evt);
            }
        });

        textPhrase.setText("to be or not to be that is the question");

        jLabel5.setText("Phrase to be found:");

        jLabel6.setText("Mutation rate:");

        textMutateRate.setText("0.01");

        jLabel8.setText("Starting population size:");

        textStartPop.setText("500");

        textBestPhrase.setEditable(false);

        textGen.setEditable(false);
        textGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textGenActionPerformed(evt);
            }
        });

        textPop.setEditable(false);

        textFitness.setEditable(false);

        enableCapsNum.setText("Capital Letters and Numbers (Slower)");

        jLabel7.setText("Loading Spinner (For Console Users Only):");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel9.setText("Statistics:");

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel10.setText("Enter settings here:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(textBestPhrase, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFitness, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(textMutateRate, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textStartPop, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(enableCapsNum, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonRun, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(choiceLoaders, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(textPhrase, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(101, 101, 101)
                            .addComponent(jLabel4))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(textGen, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(41, 41, 41)
                            .addComponent(textPop, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(listPop, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(listPop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textPhrase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textMutateRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textStartPop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(enableCapsNum))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(buttonRun, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(choiceLoaders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textBestPhrase, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(textGen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textPop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(1, 1, 1)
                        .addComponent(textFitness, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void step(){
        String phrase = textPhrase.getText();
        double mutationRate = Double.parseDouble(textMutateRate.getText());
        population = GA.assignFitness(population, phrase);
        population = GA.generatePopulation(population, mutationRate);
        printStats();
    }
    
    public double getProgress(){
        String phrase = textPhrase.getText();
        double progress = avgFitness/GA.getFitness(new Phrase(phrase,0), phrase);
        progress *= 100;
        return progress;
    }
    
    public double getFinalProgress(){
        return 100;
    }
    
    public String getProgressBar(double progress){
        String progressBar = "";
        for(int i = 0; i < (int)progress/2; i++){
            progressBar += "▇";
        }
        
        for(int i = 0; i < 50 - ((int)progress/2); i++){
            progressBar += "░";
        }
        return progressBar;
    }
    
    public void printStats(){
        String phrase = textPhrase.getText();
        System.out.println("Generation: " + generationNum + " Average Fitness: " + avgFitness + " Best Phrase: " + bestPhrase.getPhrase());
        double progress = getProgress();
        String progressBar = getProgressBar(progress);
        System.out.println("PROGRESS: [" +loadingSpinner.get(loadingNum%loadingSpinner.size()) +"] [" + (int)progress + "% " + progressBar + "]");
        loadingNum++;
    }
    
    
    private void buttonRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRunActionPerformed
        double startTimeForSolve = System.currentTimeMillis();
        String choice = choiceLoaders.getSelectedItem();
        importLoader(choice);
        avgFitness = 0;
        bestPhrase = new Phrase("",0);
        generationNum = 0;
        population = new ArrayList<>();
        boolean capsNum = enableCapsNum.isSelected();
        GA.importLetters(capsNum);
        int size = Integer.parseInt(textStartPop.getText());
        String phrase = textPhrase.getText();
        double mutationRate = Double.parseDouble(textMutateRate.getText());
        population = GA.generateFirstPopulation(phrase,size);
        if(population == null){
            System.out.println("TIMEOUT.");
            System.out.println("REALLY?");
            System.out.println("YOU CAN'T EVEN GENERATE " + size + " RANDOM PHRASES? WOW YOUR COMPUTER REALLY SUCKS. IS IT SOME KIND OF POTATO?");
            System.out.println("HOPEFULLY YOU'LL GET A NEW COMPUTER BUDDY. GOOD LUCK.");
            System.out.println("I'M GONNA CLOSE THE WINDOW FOR YOU NOW. YOU'RE WELCOME.");
            System.out.println("");
            System.out.println("SINCERELY,");
            System.out.println("FRANKWHOEE"); 
            super.dispose();
        }
        update();
        boolean timeout = false;
        double duration = 0;
        while(!bestPhrase.getPhrase().equals(phrase)){
            double startTime = System.currentTimeMillis();
            step();
            population = GA.assignFitness(population, phrase);
            updateAVGFitness();
            updateBestPhrase();
            update();
            double endTime = System.currentTimeMillis();
            if((endTime -startTime) > 5000){
                timeout = true;
                duration = (endTime - startTime);
                break;
            }
            generationNum++;
        }
        if(timeout){
            System.out.println("TIMEOUT. TIME TAKEN:" + duration + "ms");
                if(size > 1000){
                    System.out.println("STOP DICKING AROUND WITH THE POPULATION SIZE. ANYTHING GREATER THAN 1000 IS OVERKILL, AND YOUR COMPUTER CAN'T HANDLE IT.");
                    System.out.println("I'M GOING TO CLOSE THE WINDOW FOR YOU NOW. YOU'RE WELCOME.");
                    System.out.println("");
                    System.out.println("SINCERELY,");
                    System.out.println("FRANKWHOEE");
                }else{
                    System.out.println("GET A BETTER COMPUTER PLEASE.");
                    System.out.println("SERIOUSLY IF IT TAKES YOU MORE THAN 5 SECONDS TO CALCULATE " + size + " PHRASES, YOUR COMPUTER IS SCREWED.");
                    System.out.println("EVEN MY COMPUTER IS BETTER THAN THAT AND IT'S FROM 2006 OR SOMETHING LIKE THAT.");
                    System.out.println("");
                    System.out.println("I'M GOING TO CLOSE THE WINDOW FOR YOU NOW. YOU'RE WELCOME.");
                    System.out.println("SINCERELY,");
                    System.out.println("FRANKWHOEE"); 
                }
                super.dispose();
        }else{
            double endTimeForSolve = System.currentTimeMillis();
            System.out.println("");
            population = GA.assignFitness(population, phrase);
            updateAVGFitness();
            updateBestPhrase();
            update();
            avgFitness = GA.getFitness(new Phrase(phrase,0), phrase);
            System.out.println("Generation: " + generationNum + " Average Fitness: " + avgFitness + " Best Phrase: " + bestPhrase.getPhrase());
            System.out.println("PROGRESS:[✓] [" + 100 + "% " + getProgressBar(100) + "]");
            System.out.println("Phrase \"" + phrase + "\" found in " + (endTimeForSolve - startTimeForSolve)/1000 + "s");
            System.out.println("Program ended."); 
        }
        
    }//GEN-LAST:event_buttonRunActionPerformed

    private void textGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textGenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textGenActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PhraseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhraseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhraseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhraseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhraseUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonRun;
    private java.awt.Choice choiceLoaders;
    private javax.swing.JCheckBox enableCapsNum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private java.awt.List listPop;
    private java.awt.TextField textBestPhrase;
    private java.awt.TextField textFitness;
    private java.awt.TextField textGen;
    private javax.swing.JTextField textMutateRate;
    private javax.swing.JTextField textPhrase;
    private java.awt.TextField textPop;
    private javax.swing.JTextField textStartPop;
    // End of variables declaration//GEN-END:variables
}
