// has a relation ..Example



class Battery{
    int capacityMaH;
    Battery(int capacityMaH){
        this.capacityMaH = capacityMaH;
    }

    void drain(){
        System.out.println("Battery Used.\nCapacity remaining: "+(capacityMaH - 100) + "M");

    }
}

class Camera{
    int pix;
    Camera(int pix){
        this.pix = pix;
    }
    void takePhoto(){
        System.out.println("Click...Captured a photo with "+ pix + " sensor");
    }
}

class Phone{
    String brand;
    Battery battery;
    Camera camera;

    Phone(String brand, Battery battery, Camera camera){
        this.brand = brand;
        this.battery = battery;
        this.camera = camera;
    }
    void snapePicture(){
        System.out.println("[ " + brand + " ]" + " is active.");
        camera.takePhoto();
        battery.drain();
    }
}




public class relationships2 {
}
