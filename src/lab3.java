
/**
 * Клас NPC представляє персонажа з полями, які характеризують його властивості.
 */
class NPC {
    String name;      // Ім'я персонажа
    int level;        // Рівень персонажа
    String role;      // Роль персонажа
    int health;       // Кількість здоров'я
    int experience;   // Кількість досвіду

    // Конструктор
    public NPC(String name, int level, String role, int health, int experience) {
        this.name = name;
        this.level = level;
        this.role = role;
        this.health = health;
        this.experience = experience;
    }

    // Метод для виводу інформації про NPC
    public String Data() {
        return "NPC{" +
                "name='" + this.name + '\'' +
                ", level=" + this.level +
                ", role='" + this.role + '\'' +
                ", health=" + this.health +
                ", experience=" + this.experience +
                '}';
    }
}

public class lab3 {

    public static void main(String[] args) {
        // Створення масиву NPC
        NPC[] npcs = {
                new NPC("John", 5, "Trader", 100, 200),
                new NPC("Alice", 3, "Warrior", 150, 300),
                new NPC("Bob", 5, "Guard", 120, 250),
                new NPC("Diana", 2, "Mage", 90, 180),
                new NPC("Eve", 5, "Rogue", 100, 400)
        };

        // Сортування масиву: за рівнем (level) за зростанням, а за здоров'ям (health) за спаданням
        for (int i = 0; i < npcs.length - 1; i++) {
            for (int j = 0; j < npcs.length - i - 1; j++) {
                if (npcs[j].level > npcs[j + 1].level ||
                        (npcs[j].level == npcs[j + 1].level && npcs[j].health < npcs[j + 1].health)) {
                    NPC temp = npcs[j];
                    npcs[j] = npcs[j + 1];
                    npcs[j + 1] = temp;
                }
            }
        }

        // Вивід відсортованого масиву
        System.out.println("Sorted NPCs:");
        for (NPC npc : npcs) {
            System.out.println(npc.Data());
        }

        // Заданий NPC для пошуку
        NPC target = new NPC("Alice", 3, "Warrior", 150, 300);

        // Пошук об'єкта, ідентичного заданому
        boolean found = false;
        for (NPC npc : npcs) {
            if (npc.name.equals(target.name) &&
                    npc.level == target.level &&
                    npc.role.equals(target.role) &&
                    npc.health == target.health &&
                    npc.experience == target.experience) {
                found = true;
                System.out.println("Target NPC found: " + npc.Data());
                break;
            }
        }

        if (!found) {
            System.out.println("Target NPC not found.");
        }
    }
}