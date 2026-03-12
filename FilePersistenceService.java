/**
 * ============================================================
 * CLASS - FilePersistenceService
 * ============================================================
 *
 * Use Case 12: Data Persistence & System Recovery
 *
 * Description:
 * This class is responsible for persisting
 * critical system state to a plain text file.
 *
 * It supports:
 * - Saving room inventory state
 * - Restoring inventory on system startup
 *
 * No database or serialization framework
 * is used in this use case.
 *
 * @version 12.0
 */

import java.io.*;
import java.util.Map;

public class FilePersistenceService {
    public void saveInventory(RoomInventory inventory, String filePath) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {

            for (Map.Entry<String, Integer> entry
                    : inventory.getRoomAvailability().entrySet()) {

                writer.println(entry.getKey() + "=" + entry.getValue());
            }

            System.out.println("Inventory saved successfully.");

        } catch (IOException e) {

            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }
    public void loadInventory(RoomInventory inventory, String filePath) {

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("No valid inventory data found. Starting fresh.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("=");

                String roomType = parts[0];
                int count = Integer.parseInt(parts[1]);

                inventory.updateAvailability(roomType, count);
            }

        } catch (IOException e) {

            System.out.println("Error loading inventory: " + e.getMessage());
        }
    }
}