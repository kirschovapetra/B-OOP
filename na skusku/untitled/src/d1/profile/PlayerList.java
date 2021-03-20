package d1.profile;


import d1.datastore.ArrayStore;

public class PlayerList {
    private int maxCount = 5;
    private ArrayStore players;


    public PlayerList(int size) {
        this.maxCount = size;
        players = new ArrayStore(maxCount);

    }
    public boolean addPlayer(PlayerProfile player){
        return players.add(player);
    }
    public PlayerProfile findPlayer(int index){
        return (PlayerProfile) players.check(index);
    }

    public PlayerProfile findPlayer(PlayerProfile player){
        for (int i=0;i<players.getCount();i++){
            if (players.check(i).equals(player)){
                return (PlayerProfile) players.check(i);
            }
        }
        return null;
    }

    public PlayerProfile[] findPlayer(String name){
        PlayerProfile[] playerProfiles = new PlayerProfile[players.getCount()];
        for (int i = 0; i< players.getCount(); i++){
            if (((PlayerProfile)players.check(i)).getName().equals(name)) {
                playerProfiles[i] = (PlayerProfile) players.check(i);
            }
        }

        return playerProfiles;
    }
    public PlayerProfile[] getAll(){
        PlayerProfile[] playerProfiles = new PlayerProfile[players.getCount()];
        for (int i = 0; i< players.getCount(); i++){
            playerProfiles[i] = (PlayerProfile)players.check(i);
        }
        return playerProfiles;
    }

    public int getPlayerCount(){return players.getCount();}
    public int getMaxPlayerCount(){return maxCount;}

    public PlayerProfile removePlayer(int index){
        try {
            return (PlayerProfile) players.remove(index);
        }
        catch(IndexOutOfBoundsException e){
            return null;
        }
    }
}
