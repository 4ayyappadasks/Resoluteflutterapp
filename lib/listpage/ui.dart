import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:myflutterapp/listpage/controller.dart';

class UserListScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final UserListController controller = Get.put(UserListController());

    return Scaffold(
      backgroundColor: Color(0xFFA4A2A2),
      appBar: AppBar(
        centerTitle: true,
        title: Text("User List from Kotlin App"),
      ),
      body: RefreshIndicator(
        onRefresh: controller.fetchUsers,
        child: Obx(() {
          return controller.users.isEmpty
              ? Center(child: Text("No users found"))
              : ListView.builder(
            itemCount: controller.users.length,
            itemBuilder: (context, index) {
              final user = controller.users[index];
              return Card(
                color:Color(0xFFFFFFFF),
                elevation: 5,
                child: ListTile(
                  leading: CircleAvatar(
                    backgroundColor: Color(0xFFD0B8B8),
                    child: Text("${index+1}"),
                  ),
                  title: Text("user name : ${user["name"] ?? ""}",style: TextStyle(
                    fontWeight: FontWeight.bold
                  ),),
                  subtitle: Text("email : ${user["email"] ?? ""}"),
                ),
              );
            },
          );
        }),
      ),
    );
  }
}