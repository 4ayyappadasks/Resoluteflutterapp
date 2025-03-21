import 'package:flutter/services.dart';
import 'package:get/get.dart';

class UserListController extends GetxController {
  static const platform = MethodChannel('com.example.mykotlinapp/users');
  var users = <Map<String, String>>[].obs;

  @override
  void onInit() {
    super.onInit();
    fetchUsers();
  }

  Future<void> fetchUsers() async {
    try {
      final List<dynamic> result = await platform.invokeMethod('getUsers');
      users.assignAll(result.map((user) => Map<String, String>.from(user)));
    } on PlatformException catch (e) {
      print("Failed to load users: ${e.message}");
    }
  }
}