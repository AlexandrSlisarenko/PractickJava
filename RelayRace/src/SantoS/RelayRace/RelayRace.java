package SantoS.RelayRace;

public class RelayRace {
    String [] player1 = {"Men","Иван","1000","3","500","20"};
    String [] player2 = {"Men","Маша","800","2","800","50"};
    String [] player3 = {"Cat","Барсик","100","2","0","кот","чеширский","Муууррр"};
    String [] player4 = {"Cat","Мурзик","120","1","0","кот","дворовый","Мяяяу"};
    String [] player5 = {"Cat","Ириска","80","2","0","кошка","веслоухая","МурррМяяяяяуу"};
    String [] player6 = {"Dog","Полкан","1500","3","400","пес","сторожевой","Гав"};
    String [] player7 = {"Dog","Шарик","1200","2","700","пес","спаниель","РРР Гав"};
    String [] player8 = {"Dog","Волга","900","1","400","собака","дворовая","Гав Гав Гав"};
    String [][] team1data = {player1, player3,player5,player8};

    String [][] team2data = {player2, player4,player6,player7};

    Team team1 = new Team("Звезда", team1data);
    Team team2 = new Team("Победа", team2data);




}
