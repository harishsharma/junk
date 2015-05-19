package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import array.Pair;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

public class NearPeople {

    Map<Integer, User>         userIdToUser;
    Map<Integer, Set<Integer>> interestIdToListOfUserIds;

    public NearPeople() {
        userIdToUser = Maps.newHashMap();
        interestIdToListOfUserIds = Maps.newHashMap();
    }

    public void addUserIdMapping(Integer userId, User user) {
        userIdToUser.put(userId, user);
    }

    public List<Integer> getNearestUsers(Integer userId, Integer miles, Integer topNUsers) {
        // assert the inputs
        User inputUser = userIdToUser.get(userId);
        Collection<User> allUsers = userIdToUser.values();
        Queue<Pair<Integer, Integer>> heap = new PriorityQueue<>(topNUsers, (x, y) -> x.getSecond() - y.getSecond());
        for (User someUser : allUsers) {
            if (someUser.equals(inputUser)) continue;
            if (someUser.location.distanceFrom(inputUser.location) <= miles) {
                Integer scalarProduct = 1;
                for (Entry<Integer, Integer> entry : inputUser.interestIdToWeight.entrySet()) {
                    Integer interest = entry.getKey();
                    if (someUser.interestIdToWeight.containsKey(interest)) {
                        scalarProduct *= someUser.interestIdToWeight.get(interest);
                    }
                }
                Pair<Integer, Integer> pair = Pair.of(someUser.userId, scalarProduct);
                System.out.println(pair);
                if (heap.size() < topNUsers) {
                    heap.add(pair);
                } else {
                    Pair<Integer, Integer> top = heap.peek();
                    if (top.getSecond() < pair.getSecond()) {
                        heap.remove();
                        heap.add(pair);
                    }
                }
            }
        }

        List<Integer> users = Lists.newArrayList();
        while (!heap.isEmpty()) {
            users.add(heap.remove().getFirst());
        }
        return users;
    }

    public void addInterestMapping(Integer interest, Integer userId) {
        Set<Integer> userList = interestIdToListOfUserIds.get(interest);
        if (userList != null) {
            userList.add(userId);
        } else {
            userList = Sets.newHashSet();
            userList.add(userId);
            interestIdToListOfUserIds.put(interest, userList);
        }
    }

    @ToString
    @Getter
    public static class User {
        int                   userId;
        Location              location;
        Map<Integer, Integer> interestIdToWeight;

        public User(int userId, int x, int y, Map<Integer, Integer> interestIdToWeight) {
            this.userId = userId;
            this.location = new Location(x, y);
            this.interestIdToWeight = interestIdToWeight;
        }

    }

    @AllArgsConstructor
    @Getter
    @ToString
    public static class Location {
        private int x;
        private int y;

        public double distanceFrom(final Location input) {
            return Math.sqrt((input.getX() - x) * (input.getX() - x) + (input.getY() - y) * (input.getY() - y));
        }
    }

    public static void main(String[] args) throws IOException {
        NearPeople nearPeople = new NearPeople();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int totalUsers = Integer.parseInt(in.readLine());
        for (int i = 0; i < totalUsers; i++) {
            String content = in.readLine();
            String[] contentArr = content.split(" ");
            Integer len = contentArr.length;
            Integer userId = Integer.parseInt(contentArr[0]);
            Integer x = Integer.parseInt(contentArr[1]);
            Integer y = Integer.parseInt(contentArr[2]);
            Map<Integer, Integer> interestIdToWeight = Maps.newHashMap();
            for (int j = 3; j < len; j += 2) {
                Integer interestId = Integer.parseInt(contentArr[j]);
                Integer weight = Integer.parseInt(contentArr[j + 1]);
                interestIdToWeight.put(interestId, weight);
                nearPeople.addInterestMapping(interestId, userId);
            }
            User user = new User(userId, x, y, interestIdToWeight);
            nearPeople.addUserIdMapping(userId, user);
        }
        System.out.println(nearPeople.getNearestUsers(1, 3, 4));
        in.close();
    }
}
