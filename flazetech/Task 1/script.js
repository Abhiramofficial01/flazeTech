document.addEventListener('DOMContentLoaded', function () {
    const reservationForm = document.getElementById('reservationForm');
  
    reservationForm.addEventListener('submit', function (event) {
      event.preventDefault();
  
      const name = document.getElementById('name').value;
      const date = document.getElementById('date').value;
      const time = document.getElementById('time').value;
  
      // Here you can send the reservation data to the Node.js backend for processing
      // For simplicity, we'll just log the data to the console
      console.log('Name:', name);
      console.log('Date:', date);
      console.log('Time:', time);
  
      // You can make an AJAX request or use a library like Axios to send data to the backend
      // Example using fetch:
      // fetch('/api/reservations', {
      //   method: 'POST',
      //   headers: {
      //     'Content-Type': 'application/json',
      //   },
      //   body: JSON.stringify({ name, date, time }),
      // })
      //   .then(response => response.json())
      //   .then(data => console.log('Server response:', data))
      //   .catch(error => console.error('Error:', error));
    });
  });
  