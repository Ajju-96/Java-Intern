/*
Question 3: Media Player — Runtime Polymorphism

Problem Statement:
Implement playMedia(String mediaType, String title) to return a playback message.

Rules:
- If mediaType is "Song", return "Playing song: {title}".
- If mediaType is "Video", return "Playing video: {title}".
- If mediaType is "Podcast", return "Playing podcast: {title}".
- For any other media type, return "Unknown media type".
- Matching is case-sensitive.

Input:
Two lines:
1. Media type
2. Title
*/

import java.util.Scanner;

class MediaPlayer {
    static String playMedia(String mediaType, String title) {
        switch (mediaType) {
            case "Song":
                return "Playing song: " + title;
            case "Video":
                return "Playing video: " + title;
            case "Podcast":
                return "Playing podcast: " + title;
            default:
                return "Unknown media type";
        }
    }
}

public class MediaPlayerRuntime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String mediaType = sc.nextLine();
        String title = sc.nextLine();

        System.out.println(MediaPlayer.playMedia(mediaType, title));

        sc.close();
    }
}
