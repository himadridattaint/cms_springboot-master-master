//package com.cms_springboot.cms_springboot.controller;
//
//import com.cms_springboot.cms_springboot.CResponse.CResponse;
//import com.cms_springboot.cms_springboot.entity.Post;
//import com.cms_springboot.cms_springboot.entity.User;
//import com.cms_springboot.cms_springboot.exception.UserNotFoundException;
//import com.cms_springboot.cms_springboot.service.PostService;
//import com.cms_springboot.cms_springboot.service.RestClientService;
//import com.cms_springboot.cms_springboot.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//@RestController
//@RequestMapping("/users")
//public class UserController {
//    @Autowired
//    private final UserService userService;
//    private final PostService postService;
//    private final RestClientService restClientService;
//
//    @Autowired
//    public UserController(UserService userService, PostService postService) {
//        this.userService = userService;
//        this.postService = postService;
//    }
//
//    @GetMapping("/all")
//    public List<User> getAllUser()
//    {
//        return userService.getAllUsers();
//    }
//
//     @PostMapping("/add")
//    public void addUser(@RequestBody User user)
//     {
//         userService.saveUser(user);
//     }
//    @GetMapping("/{uId}")
//    public User getUserById(@PathVariable Integer uId) {
//        return userService.getUserById(uId);
//    }
//
////    @GetMapping("/{uId}/phone")
////    public String getPhoneNumberById(@PathVariable Integer uId) {
////        User user = userService.getUserById(uId);
////
////        if (user != null) {
////            return user.getPhoneNumber();
////        } else {
////            return "User not found";
////        }
////    }
////@GetMapping("/{uId}/phone")
////public String getPhoneNumberById(@PathVariable Integer uId) {
////    try {
////        User user = userService.getUserById(uId);
////
////        if (user != null) {
////            return user.getPhoneNumber();
////        } else {
////            throw new UserNotFoundException("User not found");
////        }
////    } catch (UserNotFoundException ex) {
////        // Handle the custom exception
////        return ex.getMessage(); // You can customize the response as needed
////    } catch (Exception ex) {
////        // Handle other exceptions if necessary
////        return "An unexpected error occurred";
////    }
////}
//@GetMapping("/{uId}/phone")
//public String getPhoneNumberById(@PathVariable Integer uId) {
//    try {
//        User user = userService.getUserById(uId);
//
//        if (user != null) {
//            return user.getPhoneNumber();
//        } else {
//            throw new UserNotFoundException("User not found");
//        }
//    } catch (UserNotFoundException ex) {
//        // Handle the custom exception
//        return ex.getMessage(); // You can customize the response as needed
//    } catch (Exception ex) {
//        // Handle other exceptions if necessary
//        return "An unexpected error occurred";
//    }
//}
//
//
////    @GetMapping("/{uId}/username")
////    public String getUserNameById(@PathVariable Integer uId){
////        User user = userService.getUserById(uId);
////        if(user != null){
////            return user.getUserName();
////        }
////        else{
////            return "User not listed";
////        }
////
////    }
//@GetMapping("/{uId}/username")
//public String getUserNameById(@PathVariable Integer uId)
//{
//    try
//    {
//        User user = userService.getUserById(uId);
//        if(user !=null)
//        {
//            return user.getUserName();
//        }
//        else
//        {
//            throw new UserNotFoundException("User not found");
//        }
//
//    }
//    catch (UserNotFoundException ex)
//    {
//        return ex.getMessage();
//    }
//    catch(Exception ex)
//    {
//        return "An unexpected error occurred";
//    }
//
//
//}
//
//    @GetMapping("/{uId}/post/title")
//    public String getPostTitleByUserId(@PathVariable Integer uId) {
//        User user = userService.getUserById(uId);
//
//        if (user != null && user.getPost() != null) {
//            return user.getPost().getTitle();
//        } else {
//            return "Post title not found for the user";
//        }
//    }
//
//    @GetMapping("/{uId}/post/count")
//    public Integer getPostCountByUserId(@PathVariable Integer uId) {
//        User user = userService.getUserById(uId);
//            int c=0;
//
//        if (user != null && user.getPost() != null) {
//            c++;
//            return  c;
//        } else {
//            return (int) 0;
//        }
//    }
//
//    @DeleteMapping("/{uId}")
//    public void deleteUser(@PathVariable Integer uId) {
//        userService.deleteUserById(uId);
//    }
//
//    @PutMapping("/update/{uId}")
//    public CResponse updateUser(@PathVariable Integer uId, @RequestBody User updatedUser) {
//        User existingUser = userService.getUserById(uId);
//
//        if (existingUser != null) {
//            // Update the user properties with the new values
//            existingUser.setUserName(updatedUser.getUserName());
//            existingUser.setName(updatedUser.getName());
//            existingUser.setEmail(updatedUser.getEmail());
//            existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
//            //existingUser.getUserId(updatedUser.getUserId());
//
//            // Add more properties as needed
//
//            userService.saveUser(existingUser); // Save the updated user
//
//            return new CResponse(200, "User updated successfully");
//        }
//        else {
//            return new CResponse(404, "User not found");
//        }
//   }
//
//
//}
package com.cms_springboot.cms_springboot.controller;

import com.cms_springboot.cms_springboot.CResponse.CResponse;
import com.cms_springboot.cms_springboot.entity.Post;
import com.cms_springboot.cms_springboot.entity.User;
import com.cms_springboot.cms_springboot.exception.UserNotFoundException;
import com.cms_springboot.cms_springboot.service.PostService;
import com.cms_springboot.cms_springboot.service.RestClientService;
import com.cms_springboot.cms_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final PostService postService;
    private final RestClientService restClientService; // Inject RestClientService

    @Autowired
    public UserController(UserService userService, PostService postService, RestClientService restClientService) {
        this.userService = userService;
        this.postService = postService;
        this.restClientService = restClientService;
    }

    @GetMapping("/all")
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @GetMapping("/{uId}")
    public User getUserById(@PathVariable Integer uId) {
        return userService.getUserById(uId);
    }

    @GetMapping("/{uId}/phone")
    public String getPhoneNumberById(@PathVariable Integer uId) {
        try {
            User user = userService.getUserById(uId);

            if (user != null) {
                return user.getPhoneNumber();
            } else {
                throw new UserNotFoundException("User not found");
            }
        } catch (UserNotFoundException ex) {
            return ex.getMessage();
        } catch (Exception ex) {
            return "An unexpected error occurred";
        }
    }

    @GetMapping("/{uId}/username")
    public String getUserNameById(@PathVariable Integer uId) {
        try {
            User user = userService.getUserById(uId);
            if (user != null) {
                return user.getUserName();
            } else {
                throw new UserNotFoundException("User not found");
            }

        } catch (UserNotFoundException ex) {
            return ex.getMessage();
        } catch (Exception ex) {
            return "An unexpected error occurred";
        }
    }

    @GetMapping("/{uId}/post/title")
    public String getPostTitleByUserId(@PathVariable Integer uId) {
        User user = userService.getUserById(uId);

        if (user != null && user.getPost() != null) {
            return user.getPost().getTitle();
        } else {
            return "Post title not found for the user";
        }
    }

    @GetMapping("/{uId}/post/count")
    public Integer getPostCountByUserId(@PathVariable Integer uId) {
        User user = userService.getUserById(uId);
        int c = 0;

        if (user != null && user.getPost() != null) {
            c++;
            return c;
        } else {
            return (int) 0;
        }
    }

    @DeleteMapping("/{uId}")
    public void deleteUser(@PathVariable Integer uId) {
        userService.deleteUserById(uId);
    }

    @PutMapping("/update/{uId}")
    public CResponse updateUser(@PathVariable Integer uId, @RequestBody User updatedUser) {
        User existingUser = userService.getUserById(uId);

        if (existingUser != null) {
            // Update the user properties with the new values
            existingUser.setUserName(updatedUser.getUserName());
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPhoneNumber(updatedUser.getPhoneNumber());

            // Add more properties as needed

            userService.saveUser(existingUser); // Save the updated user

            return new CResponse(200, "User updated successfully");
        } else {
            return new CResponse(404, "User not found");
        }
    }

    // New endpoint using RestClientService
    @GetMapping("/fetchDataFromEndpoint")
    public String fetchDataFromEndpoint() {
        return restClientService.fetchDataFromEndpoint();
    }
}
