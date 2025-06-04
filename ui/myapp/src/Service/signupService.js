import axios from "axios";

const api = "http://localhost:8080/api/addUser";

const registerUser = async (jsonData) => {

    try {

        const response = await axios.post(api, jsonData, {
            headers: {
                'Content-Type': 'application/json'
            }
        });

        return response.data;
    }
    catch (error) {
      
        console.error('Error:', error);
            return { error: error.message }; // Return an error object or handle it as needed
    }
}

export default registerUser;

