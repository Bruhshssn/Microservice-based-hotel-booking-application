To use or demonstrate the project, simply open terminal in the parent(root) folder and run "docker compose up". After running the command all the containers will start automatically.
Please wait 1-2 minutes after the containers start, so that the services get registered in eureka(registry-server).
ENDPOINT:  POST: http://localhost:9090/api/auth/register(register or add a user)
ENDPOINT:  POST: http://localhost:9090/api/auth/login(login a user)
ENDPOINT:  POST: http://localhost:9090/api/hotel/addHotel(add a hotel with room in the db)
ENDPOINT:  POST: http://localhost:9090/api/booking/create(create a booking with the number rooms you want to book)
ENDPOINT:  GET: http://localhost:9090/api/hotel/hotels/(get all the hotels with rooms in the db)
ENDPOINT:  DELETE: http://localhost:9090/api/booking/delete/(delete a booking using bookingId)
Please refer to the respective controller class for more info.
PLEASE USE POSTMAN TO DEMONSTRATE THE PROJECT AS I WAS NOT ABLE TO USE SWAGGER UI (my bad). IT WAS GIVING ME MANY ERRORS AND HEADACHES. ALSO I HAD LITTLE TIME TO MAKE THIS PROJECT SO PLEASE USE POSTMAN AS CLIENT.
Also please NOTE that you have to pass the jwt in the authorization everytime you make any request(jwt validation implemented in the gateway).
THNAK YOU. HOPE YOU LIKE THE PROJECT.
