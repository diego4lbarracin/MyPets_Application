
![Logo](https://private-user-images.githubusercontent.com/124466083/288210267-bbc0ad7a-9473-40bc-ac7a-36e866fda67f.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTEiLCJleHAiOjE3MDE4MTIzNjMsIm5iZiI6MTcwMTgxMjA2MywicGF0aCI6Ii8xMjQ0NjYwODMvMjg4MjEwMjY3LWJiYzBhZDdhLTk0NzMtNDBiYy1hYzdhLTM2ZTg2NmZkYTY3Zi5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBSVdOSllBWDRDU1ZFSDUzQSUyRjIwMjMxMjA1JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDIzMTIwNVQyMTM0MjNaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT05OTA5Mzg5NTI2YTdhZmRlMjJmNjUwYzAxZjhmMWVhMjQxMzk0MDEzNGE5NjBkNGUwYTRhYzBmOWMxN2I4MjczJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCZhY3Rvcl9pZD0wJmtleV9pZD0wJnJlcG9faWQ9MCJ9.AdKcGAxj6PawvUuudnCuxxdlkFN5cIpzdUOGmdD_jPc)



# MyPets

MyPets is an application to manage the operation of a chain of veterinary clinics in Java using a graphical user
interface in JavaFX and a relational database I designed for the application. In this project, once a user has logged
in and, based on the type of user (administrator, vet, or pet owner), different options such as registering a pet or
searching a user’s information are displayed.



## Features
All the types of users (administrator, vet, or pet owner) share these functionalities.
- Log in, Log out.
  ![logInLogOut](https://private-user-images.githubusercontent.com/124466083/288225785-4b8570f4-5bd3-442b-ad90-d111b3b26d32.gif?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTEiLCJleHAiOjE3MDE4MTY0MTYsIm5iZiI6MTcwMTgxNjExNiwicGF0aCI6Ii8xMjQ0NjYwODMvMjg4MjI1Nzg1LTRiODU3MGY0LTViZDMtNDQyYi1hZDkwLWQxMTFiM2IyNmQzMi5naWY_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBSVdOSllBWDRDU1ZFSDUzQSUyRjIwMjMxMjA1JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDIzMTIwNVQyMjQxNTZaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT01NGVjNTRkNTU2ZWFjYjQzYjZmZWVjNjhmYzEyZDc4Y2JjNGY4ZTE2ODVhYTBhNTY3NDRlZjRmOGQyNjVkY2EwJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCZhY3Rvcl9pZD0wJmtleV9pZD0wJnJlcG9faWQ9MCJ9.W5sfrrV4R9e8A6INIaInlzKmPT_EJwuohTi-Frd1cZw)
- Sign up (the last one only as a pet owner).
  ![SignUp](https://private-user-images.githubusercontent.com/124466083/288227597-a6ed31c9-a93d-4958-bc13-f9801792b32a.gif?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTEiLCJleHAiOjE3MDE4MTY4MzQsIm5iZiI6MTcwMTgxNjUzNCwicGF0aCI6Ii8xMjQ0NjYwODMvMjg4MjI3NTk3LWE2ZWQzMWM5LWE5M2QtNDk1OC1iYzEzLWY5ODAxNzkyYjMyYS5naWY_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBSVdOSllBWDRDU1ZFSDUzQSUyRjIwMjMxMjA1JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDIzMTIwNVQyMjQ4NTRaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT0xM2QxOGMxNDU5NWE5ZDUwYmI4NDEyNjQxZTFjNTk1MmI1NTY4ZmM3YzA3YThlOGE2ODI4ZjU3NTcyN2YxNDlkJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCZhY3Rvcl9pZD0wJmtleV9pZD0wJnJlcG9faWQ9MCJ9.kjwVnlRAS3tdLnjoERm-VlVIIIYGZrgZFLeHJ7q881k)
- Register a pet.
  ![Register a pet](https://private-user-images.githubusercontent.com/124466083/288228953-9d3bdea9-b422-4f71-b205-f647a201e626.gif?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTEiLCJleHAiOjE3MDE4MTcyOTEsIm5iZiI6MTcwMTgxNjk5MSwicGF0aCI6Ii8xMjQ0NjYwODMvMjg4MjI4OTUzLTlkM2JkZWE5LWI0MjItNGY3MS1iMjA1LWY2NDdhMjAxZTYyNi5naWY_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBSVdOSllBWDRDU1ZFSDUzQSUyRjIwMjMxMjA1JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDIzMTIwNVQyMjU2MzFaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1kNWI0MmM2YjRhOGM5ZmE2NDNlMmZjNjZmYmM5ZDhkYTNlMzg1ZTNjMDBmYmRlZDAwMmQzMzgxZDc2NTRkZDVhJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCZhY3Rvcl9pZD0wJmtleV9pZD0wJnJlcG9faWQ9MCJ9.WcXJAefIE6KhRbMZjr7H7p1_ccV3sjYQGyUthbRRR30)
- Search a pet's information.


## Administrator Profile
Besides the previous features, the Administrator profile has another features, such as:
- Delete a pet's owner account.

- Search a user's information.
  ![Logo](https://private-user-images.githubusercontent.com/124466083/288230222-6088bc75-6f0c-44dc-8ee0-16fd83a10358.gif?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTEiLCJleHAiOjE3MDE4MTc3NTMsIm5iZiI6MTcwMTgxNzQ1MywicGF0aCI6Ii8xMjQ0NjYwODMvMjg4MjMwMjIyLTYwODhiYzc1LTZmMGMtNDRkYy04ZWUwLTE2ZmQ4M2ExMDM1OC5naWY_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBSVdOSllBWDRDU1ZFSDUzQSUyRjIwMjMxMjA1JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDIzMTIwNVQyMzA0MTNaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT05YWJjZWIwOTk3ZDY0ZDNjMjljNjBjYTk1Mzk5ODJjMzJmNGI0YjZiY2IxZGY5ZGE3MDM1YTE2MTM4YzhjYjZmJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCZhY3Rvcl9pZD0wJmtleV9pZD0wJnJlcG9faWQ9MCJ9.Lj1BEuxftpUI25FW9Mg4Bu4i3qbGO8BkWU2zfrsodlw)
- Search a pet's information.
- Register a new user (only pet owners).
  On the other hand, the next features are meant to be implemented in next releases:
- Update an account's information.
- Schedule a medical appointment for a pet.
- View the inventory of medical supplies of each clinic.
- Manage medical supplies of each clinic.
## Veterinary Profile
As a Veterinary, the user has access to the main feautures and the following ones:
- Search a user's information (only pet owners).
  On the other hand, the next feautures are meant to be implemented in next releases:
- View a pet's medical history.
- Prescribe medical treatments for a pet.
- Record the results of medical examinations.
- Schedule a medical appointment for a pet.
## Pet Owner Profile
As a Pet Owner, out of the main feautures, the user also can:
- Delete a pet's owner account.
  ![DeletePO](https://private-user-images.githubusercontent.com/124466083/288230943-2dc572ac-3f09-4231-8749-56ae53b5c506.gif?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTEiLCJleHAiOjE3MDE4MTgwMTEsIm5iZiI6MTcwMTgxNzcxMSwicGF0aCI6Ii8xMjQ0NjYwODMvMjg4MjMwOTQzLTJkYzU3MmFjLTNmMDktNDIzMS04NzQ5LTU2YWU1M2I1YzUwNi5naWY_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBSVdOSllBWDRDU1ZFSDUzQSUyRjIwMjMxMjA1JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDIzMTIwNVQyMzA4MzFaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT01NTgyZTEzMzA1NmUyNDUzM2VlZDZlNDE4MmRiNTBiOGNiNGQzNDZhYWQ4YWE2ODVlYWViZDNjMGI3MmI1NzUwJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCZhY3Rvcl9pZD0wJmtleV9pZD0wJnJlcG9faWQ9MCJ9.7mp1STEQHp-O3Zk2ud-0vmF6CcsbqoELSW1zDx9P7wo)
- Delete a pet from the database.
  In addition, the following feautures are meant to be implemented in next releases:
- View a pet's medical history.
- Update a pet's information.
- Update a pet's owner information.
- Generate medical bill.
- Pay medical bill.
## Database
![Database](https://private-user-images.githubusercontent.com/124466083/288229890-0d3700ba-1f99-4992-8abd-b97791dc1c4d.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTEiLCJleHAiOjE3MDE4MTc2MDQsIm5iZiI6MTcwMTgxNzMwNCwicGF0aCI6Ii8xMjQ0NjYwODMvMjg4MjI5ODkwLTBkMzcwMGJhLTFmOTktNDk5Mi04YWJkLWI5Nzc5MWRjMWM0ZC5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBSVdOSllBWDRDU1ZFSDUzQSUyRjIwMjMxMjA1JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDIzMTIwNVQyMzAxNDRaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT05M2YxMGI0OTMyZjE4MDE2NjE3MjFiZmY2OTM0NjBmZWMzNmU3ZDllY2Y3YTBmYzFlYjI5YTQ5M2YxZmE3MzU4JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCZhY3Rvcl9pZD0wJmtleV9pZD0wJnJlcG9faWQ9MCJ9.fg9DKY5ZH4iH8GDFYieP8fuwEb3BrFe624W0pI4Wc20)