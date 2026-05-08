package main;

import java.util.Scanner;

public class App {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		String[] contacts = new String[100];
		
		System.out.println("Сервис контактов");
		
		while (true) { 
			System.out.println();
			System.out.println("Выберите действие (введите номер 1-4):");
			System.out.println();
			System.out.println("1. Добавить контакт");
			System.out.println("2. Показать контакты");
			System.out.println("3. Найти контакт");
			System.out.println("4. Удалить контакт");
			System.out.println("5. Выход");
			System.out.println();

			int choice = Integer.parseInt(scanner.nextLine());
			System.out.println();

			switch (choice) {
				case 1 -> {
					if (contacts[contacts.length - 1] != null) {
						System.out.println("Достигнут лимит контактов.");
						break;
					}

					System.out.print("Введите имя контакта: ");
					String name = scanner.nextLine().trim();
					System.out.print("Введите номер телефона контакта: ");
					String phone = scanner.nextLine().trim();
					
					String newContact = name + ": " + phone;

					for (int i = 0; i < contacts.length; i++) {
						if (contacts[i] == null) {
							contacts[i] = newContact;
							break;
						}
					}

					break;
				}
				case 2 -> {
					if (contacts[0] == null) {
						System.out.println("Нет контактов");
						System.out.println();
						break;
					}

					for (int i = 0; i < contacts.length; i++) {
						String mappedContact = contacts[i];

						if (mappedContact == null) break;
						
						System.out.println(i + 1 + ". " + mappedContact);
						System.out.println();
					}

					break;
				}
				case 3 -> {
					System.out.print("Имя контакта: ");
					String name = scanner.nextLine();
					boolean found = false;

					for (int i = 0; i < contacts.length; i++) {
						String lookupContact = contacts[i];

						if (lookupContact == null) break;

						if (lookupContact.contains(name)) {
							System.out.println("Телефон " + lookupContact);
							System.out.println();
							found = true;
							break;
						}
					}

					if (found) break;

					System.out.println("Контакт не найден");
					System.out.println();

					break;
				}
							
				case 4 -> {
					System.out.print("Введите имя контакта: ");
					String name = scanner.nextLine();
					boolean found = false;

					for (int i = 0; i < contacts.length; i++) {
						String inspectedContact = contacts[i];

						if (inspectedContact == null) break;

						if (inspectedContact.split(": ")[0].equals(name)) {
							found = true;
						}

						if (found) {
							if (i != contacts.length - 1) {
								contacts[i] = contacts[i + 1];
							} else {
								contacts[i] = null;
							}
						}
					}

					if (found) {
						System.out.println("Контакт удален");
						System.out.println();
					} else {
						System.out.println("Контакт не найден");
						System.out.println();
					}

					break;
				}

				case 5 -> {
					System.out.println("До свидания!");
					scanner.close();
					System.exit(0);
				}

				default -> {
					System.out.println("Неверное действие");
					System.out.println();
				}
			}
		}
	}
}
