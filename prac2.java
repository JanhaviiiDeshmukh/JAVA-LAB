import java.util.*;

public class LogisticsSystem {

    // 1. SET → Unique Tracking IDs
    static Set<String> trackingIds = new HashSet<>();

    // 2. ARRAYLIST → Shipment movement history (ordered)
    static ArrayList<String> shipmentHistory = new ArrayList<>();

    // 3. MAP → Warehouse → (Product → Quantity)
    static Map<String, Map<String, Integer>> warehouseStock = new HashMap<>();

    public static void main(String[] args) {

        // ----- UNIQUE TRACKING (SET) -----
        addTrackingId("PKG101");
        addTrackingId("PKG102");
        addTrackingId("PKG101"); // duplicate, ignored

        System.out.println("Tracking IDs: " + trackingIds);

        // ----- ORDERED PROCESSING (ARRAYLIST) -----
        addCheckpoint("PKG101 arrived at Mumbai Hub");
        addCheckpoint("PKG101 departed Mumbai Hub");
        addCheckpoint("PKG101 arrived at Pune Hub");

        System.out.println("\nShipment History:");
        for (String log : shipmentHistory) {
            System.out.println(log);
        }

        // ----- FAST LOOKUP (MAP) -----
        addStock("WH1", "Laptop", 50);
        addStock("WH1", "Mobile", 100);
        addStock("WH2", "Tablet", 30);

        System.out.println("\nWarehouse Stock:");
        System.out.println(warehouseStock);
    }

    // Add tracking ID (Set prevents duplicates)
    static void addTrackingId(String id) {
        if (trackingIds.add(id)) {
            System.out.println("Tracking ID added: " + id);
        } else {
            System.out.println("Duplicate Tracking ID ignored: " + id);
        }
    }

    // Add shipment checkpoint (keeps order)
    static void addCheckpoint(String checkpoint) {
        shipmentHistory.add(checkpoint);
    }

    // Add stock to warehouse
    static void addStock(String warehouseId, String product, int quantity) {
        warehouseStock.putIfAbsent(warehouseId, new HashMap<>());
        Map<String, Integer> productStock = warehouseStock.get(warehouseId);

        productStock.put(product,
                productStock.getOrDefault(product, 0) + quantity);
    }
}
