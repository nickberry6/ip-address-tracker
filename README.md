### What would you do differently if you had more time?
I might choose to leverage a TreeMap data structure to store IP-frequency values efficiently so that we could have constant time lookups for top100 without overly impacting the performance of "request_handled".

### What are the runtime complexities of each function?
request_handled: O(1) or constant time, because reading and writing values to a hashmap are constant time.

top100: About O(n log n) or logarithmic time because the stream api "sorted" method leverages a TimSort algorithm, which has a worst case time complexity of O(n log n).

clear: O(1) since clearing the map is a constant time operation.


### How does this code work?
request_handled takes a request and checks whether or not the IP address has already been seen. If it has been seen, we will increment the frequency value and write it to the map. If not we will add the ip with a frequency of 1.

top100 sorts the entries in the map by value, limits them to 100, and returns them as a list.

### What other approaches did you decide not to pursue?
I decided not to implement an approach where the top 100 is calculated and stored when "request_handled" is called. My rationale for this is that since this is called so often we want this method to be as efficient as possible and not do expensive computations for top100 as a side effect every request.

### How would you test this?
I would test this by generating sample inputs and expected results and implementing unit tests that correspond to the appropriate logic.