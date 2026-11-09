class Solution {

    class Car {
        int position;
        int speed;
        float eta; // estimated time of arival in hours

        Car(int position, int speed, int target) {
            this.position = position;
            this.speed = speed; 
            this.eta = Float.valueOf(target - position) / speed;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            cars.add(new Car(position[i], speed[i], target));
        }

        cars.sort((a, b) -> Float.compare(a.position, b.position));

        for (int i = 0; i < n; i++) {
            System.out.print(String.valueOf(cars.get(i).position) + " ");
        }

        int fleets = 1; 
        float current = cars.get(n - 1).eta;

        for (int i = n - 2; i >= 0; i--) {
            if (cars.get(i).eta > current) {
                fleets++;
                current = cars.get(i).eta;
            }
        }

        return fleets;
    }
}
