packagecom.example.myappla tion;
import static android.content.ContentValues.TAG;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Connection;
import java.sql.ResultSet;
public class MainActivity extends AppCompatActivity {
 //private FirebaseAuth mAuth;
 // DatabaseReference usersRef =
FirebaseDatabase.getInstance().getReferenceFromUrl("https://android-app-98dcddefault-rtdb.firebaseio.com/");
 DatabaseReference usersRef1 =
FirebaseDatabase.getInstance().getReference("users/staff");
 DatabaseReference usersRef2 =
FirebaseDatabase.getInstance().getReference("users/password");
 DatabaseReference usersRef3 =
FirebaseDatabase.getInstance().getReference("users/student");
 DatabaseReference usersRef4 =
FirebaseDatabase.getInstance().getReference("users/password1");
 DatabaseReference usersRef5 =
FirebaseDatabase.getInstance().getReference("users/admin");
 DatabaseReference usersRef6 =
FirebaseDatabase.getInstance().getReference("users/password2");
 String otpCode = String.valueOf((int) (Math.random() * 900000) + 100000);
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 EditText USERNAME = findViewById(R.id.Idno);
 EditText Password = findViewById(R.id.passWord);
 EditText Regno = findViewById(R.id.Regno1);

EditText Dob = findViewById(R.id.dob1);
 EditText Regno1 = findViewById(R.id.Idno1);
 EditText Dob1 = findViewById(R.id.passWord1);
 Button button = findViewById(R.id.button1);
 Button button1 = findViewById(R.id.button2);
 Button button2 = findViewById(R.id.button3);
 button.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) {
 String username = USERNAME.getText().toString();
 String userPass = Password.getText().toString();
 Handler handler = new Handler();
 Runnable r = new Runnable() {
 public void run() {
 if (username.isEmpty() && userPass.isEmpty()) {
 Toast.makeText(getApplicationContext(), "please enter your username
and password",
 Toast.LENGTH_LONG).show();
 } else {
 usersRef1.addListenerForSingleValueEvent(new ValueEventListener() {
 @Override
 public void onDataChange(@NonNull DataSnapshot snapshot) {
 for (DataSnapshot userSnapshot : snapshot.getChildren()) {
 String storedEmail = userSnapshot.getValue(String.class);
 String key1 = userSnapshot.getKey();

Log.d(TAG, "Value is:" + storedEmail);
 if (storedEmail.equals(username)) {
 Toast.makeText(getApplicationContext(), "username is correct",
 Toast.LENGTH_LONG).show();
 usersRef2.addValueEventListener(new ValueEventListener() {
 @Override
 public void onDataChange(@NonNull DataSnapshot
dataSnapshot) {
 for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
 String password = userSnapshot.getValue(String.class);
String key2 = userSnapshot.getKey();
 Log.d(TAG, "Value is:" + password);
 System.out.println(userPass);
// System.out.println(password);
 if (password.equals(userPass)) {
 Toast.makeText(getApplicationContext(), "password is correct",
 Toast.LENGTH_LONG).show();
 if (key1.equals(key2)) {
 //Toast.makeText(getApplicationContext(), "loginsuccessful",
 // Toast.LENGTH_LONG).show();
Toast.makeText(getApplicationContext(), "loginsuccessful",
 Toast.LENGTH_LONG).show();
 Intent i = new Intent(MainActivity.this,MainActivity3.class);
 i.putExtra("name",username);
 startActivity(i);


} else {
 Toast.makeText(getApplicationContext(), "keys are
not equal",
 Toast.LENGTH_LONG).show();
 }
 } else {
 Toast.makeText(getApplicationContext(), "invalid password",
 Toast.LENGTH_LONG).show();
 }
 }
 }
 @Override
 public void onCancelled(@NonNull DatabaseError databaseError) {
 // Handle error
 }
 });
 } else {
 Toast.makeText(getApplicationContext(), "user not found", Toast.LENGTH_LONG).show();
 }
 }
 }
 @Override
 public void onCancelled(@NonNull DatabaseError error) {
 Log.e(TAG, "onCancelled", error.toException());


}
 });
 }
 }
 /*usersRef.addListenerForSingleValueEvent(new ValueEventListener() {
 String username = USERNAME.getText().toString();
 String userPass = Password.getText().toString();
 public void onDataChange(DataSnapshot dataSnapshot) {
 for (DataSnapshot userSnapshot: dataSnapshot.getChildren()) {
 String storedEmail =
userSnapshot.child("users").child("staff").child("name").getValue(String.class);
 String password =
userSnapshot.child("users").child("staff").child("password").getValue(String.class);
 if (username.equals(storedEmail) && userPass.equals(password)) {
 Toast.makeText(getApplicationContext(), "login successful!",
 Toast.LENGTH_LONG).show();
 }
 }
 }
 @Override
 public void onCancelled(DatabaseError databaseError) {
 Log.e(TAG, "onCancelled", databaseError.toException());
 }*/
 };
 handler.postDelayed(r, 1000);
 }
 });


button1.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View view) {
 String username = Regno.getText().toString();
 String userPass = Dob.getText().toString();
 Handler handler = new Handler();
 Runnable r = new Runnable() {
 public void run() {
 if (username.isEmpty() && userPass.isEmpty()) {
 Toast.makeText(getApplicationContext(), "please enter your username and password",
 Toast.LENGTH_LONG).show();
 } else {
 usersRef3.addListenerForSingleValueEvent(new ValueEventListener() {
 @Override
 public void onDataChange(@NonNull DataSnapshot snapshot) {
 for (DataSnapshot userSnapshot : snapshot.getChildren()) {
 String storedEmail = userSnapshot.getValue(String.class);
 String key1 = userSnapshot.getKey();
 Log.d(TAG, "Value is:" + storedEmail);
 if (storedEmail.equals(username)) {
 Toast.makeText(getApplicationContext(), "username is correct",
 Toast.LENGTH_LONG).show();


usersRef4.addValueEventListener(new ValueEventListener() {
 @Override
 public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
 for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
 String password = userSnapshot.getValue(String.class);
 String key2 = userSnapshot.getKey();
Log.d(TAG, "Value is:" + password);
 System.out.println(userPass);
 // System.out.println(password);
if (password.equals(userPass)) {
 Toast.makeText(getApplicationContext(), "password is correct",
 Toast.LENGTH_LONG).show();
 if (key1.equals(key2)) {
 //Toast.makeText(getApplicationContext(), "login successful",
 // Toast.LENGTH_LONG).show();
 Toast.makeText(getApplicationContext(), "login successful",
 Toast.LENGTH_LONG).show();
 Intent i = new Intent(MainActivity.this, MainActivity6.class);
 i.putExtra("name",username);
 startActivity(i);
 } else {
 Toast.makeText(getApplicationContext(), "keys are not equal",
 Toast.LENGTH_LONG).show();
 }
 } else {


Toast.makeText(getApplicationContext(), "invalid
password",
 Toast.LENGTH_LONG).show();
 }
 }
 }
 @Override
 public void onCancelled(@NonNull DatabaseError databaseError) {
 // Handle error
 }
 });
 } else {
 Toast.makeText(getApplicationContext(), "user not found",
 Toast.LENGTH_LONG).show();
 }
 }
 }
 @Override
 public void onCancelled(@NonNull DatabaseError error) {
 Log.e(TAG, "onCancelled", error.toException());
 }
 });
 }
 }


/*usersRef.addListenerForSingleValueEvent(new ValueEventListener() {
 String username = USERNAME.getText().toString();
 String userPass = Password.getText().toString();
 public void onDataChange(DataSnapshot dataSnapshot) {
 for (DataSnapshot userSnapshot: dataSnapshot.getChildren()) {
 String storedEmail = userSnapshot.child("users").child("staff").child("name").getValue(String.class);
 String password = userSnapshot.child("users").child("staff").child("password").getValue(String.class);
 if (username.equals(storedEmail) && userPass.equals(password)) {
 Toast.makeText(getApplicationContext(), "login successful!",
 Toast.LENGTH_LONG).show();
 }
 }
 }
 @Override
 public void onCancelled(DatabaseError databaseError) {
 Log.e(TAG, "onCancelled", databaseError.toException());
 }*/
 };
 handler.postDelayed(r, 1000);
 }
 });
 button2.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View view) {
 String username = Regno1.getText().toString();
 String userPass = Dob1.getText().toString();
 Handler handler = new Handler();


Runnable r = new Runnable() {
 public void run() {
 if (username.isEmpty() && userPass.isEmpty()) {
 Toast.makeText(getApplicationContext(), "please enter your username and password",
 Toast.LENGTH_LONG).show();
 } else {
 usersRef5.addListenerForSingleValueEvent(new ValueEventListener() {
 @Override
 public void onDataChange(@NonNull DataSnapshot snapshot) {
 for (DataSnapshot userSnapshot : snapshot.getChildren()) {
 String storedEmail = userSnapshot.getValue(String.class);
 String key1 = userSnapshot.getKey();
 Log.d(TAG, "Value is:" + storedEmail);
 if (storedEmail.equals(username)) {
 Toast.makeText(getApplicationContext(), "username is correct",
 Toast.LENGTH_LONG).show();
 usersRef6.addValueEventListener(new ValueEventListener() {
 @Override
 public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
 for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
 String password = userSnapshot.getValue(String.class);
 String key2 = userSnapshot.getKey();
Log.d(TAG, "Value is:" + password);


System.out.println(userPass);
// System.out.println(password);
if (password.equals(userPass)) {
 Toast.makeText(getApplicationContext(), "password is correct",
 Toast.LENGTH_LONG).show();
 if (key1.equals(key2)) {
 //Toast.makeText(getApplicationContext(), "login successful",
 // Toast.LENGTH_LONG).show();
Toast.makeText(getApplicationContext(), "login successful",
 Toast.LENGTH_LONG).show();
 Intent i = new Intent(MainActivity.this, MainActivity4.class);
 startActivity(i);
 } else {
 Toast.makeText(getApplicationContext(), "keys are not equal",
 Toast.LENGTH_LONG).show();
 }
 } else {
 Toast.makeText(getApplicationContext(), "invalid password",
 Toast.LENGTH_LONG).show();
 }
 }
 } @Override
 public void onCancelled(@NonNull DatabaseError databaseError) {
 // Handle error

}
 });
 } else {
 Toast.makeText(getApplicationContext(), "user not found",
 Toast.LENGTH_LONG).show();
 }
 }
 }
 @Override
 public void onCancelled(@NonNull DatabaseError error) {
 Log.e(TAG, "onCancelled", error.toException());
 }
 });
 }
 }
 /*usersRef.addListenerForSingleValueEvent(new ValueEventListener() {
 String username = USERNAME.getText().toString();
 String userPass = Password.getText().toString();
 public void onDataChange(DataSnapshot dataSnapshot) {
 for (DataSnapshot userSnapshot: dataSnapshot.getChildren()) {
 String storedEmail = userSnapshot.child("users").child("staff").child("name").getValue(String.class);
 String password = userSnapshot.child("users").child("staff").child("password").getValue(String.class);
 if (username.equals(storedEmail) && userPass.equals(password)) {
 Toast.makeText(getApplicationContext(), "login successful!",

Toast.LENGTH_LONG).show();
 }
 }
 }
 @Override
 public void onCancelled(DatabaseError databaseError) {
 Log.e(TAG, "onCancelled", databaseError.toException());
 }*/
 };
 handler.postDelayed(r, 1000);
 }
 });
 }
}