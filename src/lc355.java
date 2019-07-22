import java.util.*;

public class lc355 {
    /**
    * Your Twitter object will be instantiated and called as such:
    * Twitter obj = new Twitter();
    * obj.postTweet(userId,tweetId);
    * List<Integer> param_2 = obj.getNewsFeed(userId);
    * obj.follow(followerId,followeeId);
    * obj.unfollow(followerId,followeeId);
    */
    public static void main(String[] args) {
        Twitter t = new Twitter();
        t.follow(3,1);
        t.follow(2,1);
        t.postTweet(1,6);
        t.postTweet(2,4);
        t.postTweet(3,5);
        t.postTweet(1,9);
        t.postTweet(2,44);
        t.postTweet(3,58);

        System.out.println(t.getNewsFeed(2));
        t.unfollow(2,1);
        System.out.println(t.getNewsFeed(2));

        Twitter tt = new Twitter();
        tt.postTweet(1,1);
        System.out.println(tt.getNewsFeed(1));
        tt.follow(2,1);
        System.out.println(tt.getNewsFeed(2));
        tt.unfollow(2,1);
        System.out.println(tt.getNewsFeed(2));


    }

}
class Twitter {

    class Tweet {
        int tid;
        int timeStamp;
        Tweet next = null;

        public int getTid() {
            return tid;
        }

        public Tweet(int tid, int timeStamp) {
            this.tid = tid;
            this.timeStamp = timeStamp;
        }

        public int getTimeStamp() {
            return timeStamp;
        }


    }

    class User{
        int userId;
        Set<Integer> followed = new HashSet<>();
        List<Tweet> tweets = new ArrayList<>();
        Tweet tweet_head = null;

        public User(int userId) {
            this.userId = userId;
            followed.add(userId);
        }
        public void follow(int userId) {
            followed.add(userId);
        }
        public void unfollow(int userId) {
            followed.remove(userId);
        }
        public void postTweet(Tweet tweet) {
            tweets.add(tweet);
            if(tweet_head == null) {
                tweet_head = tweet;
            }
            else
                tweet.next= tweet_head;
                tweet_head = tweet;
        }
        public List getTweets() {
            return tweets;
        }


    }

    Map<Integer,User> userMap;
    int time = 0;

    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
      if(userMap.get(userId) == null) {
          User user = new User(userId);
          Tweet tweet = new Tweet(tweetId, time++);
          user.postTweet(tweet);
          userMap.put(userId, user);
      }
      else {
          User user = userMap.get(userId);
          Tweet tweet = new Tweet(tweetId, time++);
          user.postTweet(tweet);
      }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> relevantUsersIds = userMap.get(userId).followed;
        List<Tweet>tweets = new ArrayList<>();
        Iterator<Integer> iterator = relevantUsersIds.iterator();
        while(iterator.hasNext()) {
            List<Tweet> uTweet = userMap.get(iterator.next()).getTweets();
            tweets.addAll(uTweet);
        }
        PriorityQueue<Tweet> priorityQueue = new PriorityQueue<>((x,y)-> y.timeStamp-x.timeStamp);
        priorityQueue.addAll(tweets);
        int n = 1;
        List<Integer>res = new ArrayList<>();
        while(!priorityQueue.isEmpty() && n <=10) {
            res.add(priorityQueue.poll().tid);
            n++;
        }
        return res;
    }

    public List<Integer>getNewsFeedusingLinkedList(int userId) {
        Set<Integer> relevantUsersIds = userMap.get(userId).followed;
        List<Tweet>tweets = new ArrayList<>();
        Iterator<Integer> iterator = relevantUsersIds.iterator();
        while(iterator.hasNext()) {
            Tweet t = userMap.get(iterator.next()).tweet_head;
            if(t != null)
            tweets.add(t);
        }
        PriorityQueue<Tweet> priorityQueue = new PriorityQueue<>((x,y)-> y.timeStamp-x.timeStamp);
        int n = 1;
        priorityQueue.addAll(tweets);
        List<Integer> res = new ArrayList<>();
        while(n <=10 && !priorityQueue.isEmpty()) {
            Tweet e = priorityQueue.poll();
            res.add(e.tid);
            if(e.next != null) {
                priorityQueue.add(e.next);
            }
            n++;

        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            User u = new User(followerId);
            userMap.put(followerId, u);
        }
        if(!userMap.containsKey(followeeId)){
            User u = new User(followeeId);
            userMap.put(followeeId, u);
        }
        userMap.get(followerId).follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(userMap.get(followerId) == null) return;
        User user = userMap.get(followerId);
        if(followeeId != followeeId) //one cannot unfollow itself
            user.unfollow(followeeId);
    }
}
class Tuple3 <T,S, R> {
   private T t;
   private S s;
   private R r;
   public Tuple3(T t, S s, R r){
        this.t = t;
        this.s = s;
        this.r = r;
    }
   public T getF() {
       return t;
   }
   public S getS() {
        return s;
    }
   public R getT() {
        return r;
    }


}
