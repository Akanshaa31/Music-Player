import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        //create object of album
        Album album = new Album("Album1", "Arijit Singh");
        album.addSong("Tum hi ho", 4.5);
        album.addSong("Kesariya", 3.0);
        album.addSong("Shayad", 3.5);
        album.addSong("Bolna", 4.5);
        albums.add(album);

        album = new Album("Album2", "Armaan Malik");
        album.addSong("Jab Tak", 4.0);
        album.addSong("Sab Tera", 2.5);
        album.addSong("Bol Do Na Zara", 4.5);
        album.addSong("Wajha Tum Ho", 4.5);
        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();
        albums.get(0).addToPlayList("Tum hi ho", playList_1);
        albums.get(0).addToPlayList("Bolna", playList_1);
        albums.get(1).addToPlayList("Wajha Tum Ho", playList_1);
        albums.get(1).addToPlayList("Sab Tera", playList_1);
        albums.get(0).addToPlayList("kesariya", playList_1);
        albums.get(0).addToPlayList("Shayad", playList_1);
        albums.get(1).addToPlayList("Bol Do Na Zara", playList_1);
        albums.get(1).addToPlayList("Jab Tak", playList_1);


        play(playList_1);

    }

    //play our playlist
    private static void play(LinkedList<Song> playList) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.size() == 0) {
            System.out.println("This playlist has no song");
        }
        else {
            System.out.println("Now playing" + listIterator.next().toString());
            printMenu();
        }
            while (!quit) {
                int action = sc.nextInt();
                sc.nextLine();

                switch (action) {
                    case 0:
                        System.out.println("Playlist complete!");
                        quit = true;
                        break;

                    case 1:
                        if (!forward) {
                            if (listIterator.hasNext()) {
                                listIterator.next();
                            }
                            forward = true;
                        }
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next().toString());
                        } else {
                            System.out.println("We have reached to the end of the playlist,hence no next song");
                            forward = false;
                        }
                        break;

                    case 2:
                        if (forward) {
                            if (listIterator.hasPrevious()) {
                                listIterator.previous();
                            }
                            forward = false;
                        }
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous().toString());
                        } else {
                            System.out.println("You are at the first song,hence no previous song");
                            forward = false;
                        }
                        break;

                    case 3:
                        if (forward) {
                            if (listIterator.hasPrevious()) {
                                System.out.println("Now playing " + listIterator.previous().toString());
                                forward = false;
                            } else {
                                System.out.println("We are at the start of the playlist");
                            }
                        } else {
                            if (listIterator.hasNext()) {
                                System.out.println("Now playing " + listIterator.next().toString());
                                forward = true;
                            } else {
                                System.out.println("We have reached the end of the playlist");
                            }
                        }
                        break;

                    case 4:
                        printList(playList);
                        break;

                    case 5:
                        printMenu();
                        break;

                    case 6:
                        if (playList.size() > 0) {
                            listIterator.remove();
                            if (listIterator.hasNext()) {
                                System.out.println("Now playing " + listIterator.next().toString());
                            }
                            else {
                                if (listIterator.hasPrevious())
                                    System.out.println("Now playing " + listIterator.previous().toString());

                            }
                        }
                        break;
                }
            }
         }
        //print all the actions that can be performed
       private static void printMenu(){
           System.out.println("Available options:\n Press");
           System.out.println("0 - to quit \n" +"1 - play next song \n" +
                   "2 - to play previous song \n" + "3 - to replay the current song \n" +
                   "4 - list all the songs \n" +"5 - print all available options \n"+
                   "6 - delete the current song\n");
    }
    //print the playlist
    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("**************************************");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("**************************************");
     }
    }
