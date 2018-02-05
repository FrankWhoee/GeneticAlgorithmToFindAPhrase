
package geneticalgo;

import java.awt.Color;
import java.util.ArrayList;

public class PhraseUI extends javax.swing.JFrame {
    ArrayList<Phrase> population = new ArrayList<>();
    Phrase bestPhrase = new Phrase("",0);
    int generationNum = 0;
    double avgFitness = 0;
    ArrayList<String> loadingSpinner = new ArrayList<>();
    int loadingNum = 0;
    double score = 1;
    
    public PhraseUI() {
        initComponents();
        importLoaderChoices();
        updatePerformanceProjection();
        
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
        enableCaps = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        choiceLoaders = new java.awt.Choice();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        enableNum = new javax.swing.JCheckBox();
        enableSymbols = new javax.swing.JCheckBox();
        labelPerformance = new javax.swing.JLabel();
        buttonBenchmark = new javax.swing.JButton();
        enableLowercase = new javax.swing.JCheckBox();
        labelETA = new javax.swing.JLabel();

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

        enableCaps.setText("Capital Letters (Affects Performance Negatively)");
        enableCaps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enableCapsActionPerformed(evt);
            }
        });

        jLabel7.setText("Loading Spinner (For Console Users Only):");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel9.setText("Statistics:");

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel10.setText("Enter settings here:");

        enableNum.setText("Numbers (Affects Performance Negatively)");
        enableNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enableNumActionPerformed(evt);
            }
        });

        enableSymbols.setText("Symbols (Affects Performance Negatively)");
        enableSymbols.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enableSymbolsActionPerformed(evt);
            }
        });

        labelPerformance.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        labelPerformance.setText("Projected Performance:");

        buttonBenchmark.setText("Benchmark");
        buttonBenchmark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBenchmarkActionPerformed(evt);
            }
        });

        enableLowercase.setSelected(true);
        enableLowercase.setText("Lowercase Letters");
        enableLowercase.setToolTipText("");
        enableLowercase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enableLowercaseActionPerformed(evt);
            }
        });

        labelETA.setText("ETA: ");

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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonBenchmark, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(labelPerformance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(enableNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(enableCaps, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(enableSymbols, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(enableLowercase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(labelETA)))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                    .addComponent(enableLowercase))))
                        .addGap(2, 2, 2)
                        .addComponent(enableCaps)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enableNum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enableSymbols)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelPerformance, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelETA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonBenchmark, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(buttonRun, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(choiceLoaders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(49, 49, 49)
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
                .addContainerGap())
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
    
    public void getCPUBenchmark(){
        double startTime = System.currentTimeMillis();
        
        boolean lowercase = enableLowercase.isSelected();
        boolean caps = enableCaps.isSelected();
        boolean num = enableNum.isSelected();
        boolean punct = enableSymbols.isSelected();
        
        int size = Integer.parseInt(textStartPop.getText()) * 2;
        String phrase = textPhrase.getText();
        GA.importLetters(lowercase,caps,num,punct);
        population = GA.generateFirstPopulation(phrase,size);
        population = GA.assignFitness(population, phrase);
        population = GA.generatePopulation(population, 0.01);
        double endTime = System.currentTimeMillis();
        double generationTime = endTime - startTime;
        System.out.println(generationTime + "ms to generate a population of " + size);
        int projectedGenerations = (int)((phrase.length() * generationTime) + ((0.1 * 0.1) * generationTime));
        labelETA.setText("ETA: " + projectedGenerations * generationTime/1000 + "s (extremely inaccurate, still in testing.)");
        score = generationTime/1000;
        updatePerformanceProjection();
    }
    
    public void updatePerformanceProjection(){
        boolean lowercase = enableLowercase.isSelected();
        boolean caps = enableCaps.isSelected();
        boolean num = enableNum.isSelected();
        boolean punct = enableSymbols.isSelected();
        
        double performance = 0;
        if(lowercase){
            performance += 0.1 * score;
        }
        if(caps){
            performance += 2 * score;
        }
        if(num){
            performance += score;
        }
        if(punct){
            performance+= 1.5 * score;
        }
        
        if(performance >= 3){
            labelPerformance.setForeground(Color.getHSBColor(0, 1, (float)0.7));
            labelPerformance.setText("Projected Performance: Impossible");
        }else if(performance >= 2){
            labelPerformance.setForeground(Color.getHSBColor((float)0.1, 1, (float)0.9));
            labelPerformance.setText("Projected Performance: Bad");
        }else if(performance >=1){
            labelPerformance.setForeground(Color.YELLOW);
            labelPerformance.setText("Projected Performance: Decent");
        }else{
            labelPerformance.setForeground(Color.getHSBColor((float)0.33, 1, (float)0.8));
            labelPerformance.setText("Projected Performance: Good");
        }
        
        
    }
    
    private void buttonRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRunActionPerformed
        //Record time to solve
        double startTimeForSolve = System.currentTimeMillis();
        //Get which cosmetic loader the user wants in console
        String choice = choiceLoaders.getSelectedItem();
        //Import the loader that the user wants.
        importLoader(choice);
        //Reset all variables
        avgFitness = 0;
        bestPhrase = new Phrase("",0);
        generationNum = 0;
        population = new ArrayList<>();
        
        //Get which features the user wants
        boolean lowercase = enableLowercase.isSelected();
        boolean caps = enableCaps.isSelected();
        boolean num = enableNum.isSelected();
        boolean symbols = enableSymbols.isSelected();
        
        //Import letters that the GA will need
        GA.importLetters(lowercase,caps,num,symbols);
        
        //Get the starting population size the user wants
        int size = Integer.parseInt(textStartPop.getText());
        
        //Get the desired phrase
        String phrase = textPhrase.getText();
        
        if(!GA.verifyString(phrase)){
            System.out.println("INVALID LETTERS OR SYMBOLS.");
            return;
        }
        
        //Get the mutation rate
        double mutationRate = Double.parseDouble(textMutateRate.getText());
        
        //Generate first population
        population = GA.generateFirstPopulation(phrase,size);
        
        //Means that the generation took too long.
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
        
        //Update lists and statistics
        updateAVGFitness();
        updateBestPhrase();
        update();
        
        //Reset variables
        boolean timeout = false;
        double duration = 0;
        
        //Start solving.
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

    private void enableSymbolsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enableSymbolsActionPerformed
       updatePerformanceProjection();
    }//GEN-LAST:event_enableSymbolsActionPerformed

    private void enableNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enableNumActionPerformed
       updatePerformanceProjection();
    }//GEN-LAST:event_enableNumActionPerformed

    private void enableCapsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enableCapsActionPerformed
        updatePerformanceProjection();
    }//GEN-LAST:event_enableCapsActionPerformed

    private void buttonBenchmarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBenchmarkActionPerformed
        getCPUBenchmark();
    }//GEN-LAST:event_buttonBenchmarkActionPerformed

    private void enableLowercaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enableLowercaseActionPerformed
        updatePerformanceProjection();
    }//GEN-LAST:event_enableLowercaseActionPerformed

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
    private javax.swing.JButton buttonBenchmark;
    private javax.swing.JButton buttonRun;
    private java.awt.Choice choiceLoaders;
    private javax.swing.JCheckBox enableCaps;
    private javax.swing.JCheckBox enableLowercase;
    private javax.swing.JCheckBox enableNum;
    private javax.swing.JCheckBox enableSymbols;
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
    private javax.swing.JLabel labelETA;
    private javax.swing.JLabel labelPerformance;
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
