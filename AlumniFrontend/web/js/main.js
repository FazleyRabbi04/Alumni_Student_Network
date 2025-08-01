// Sample event data (to be replaced with API call)
const events = [
    { title: "Alumni Reunion 2025", date: "2025-08-15" },
    { title: "Career Fair 2025", date: "2025-09-01" },
    { title: "Mentorship Workshop", date: "2025-10-10" }
];

document.addEventListener('DOMContentLoaded', () => {
    const viewEventsBtn = document.getElementById('viewEventsBtn');
    const eventList = document.getElementById('eventList');

    viewEventsBtn.addEventListener('click', () => {
        if (eventList.style.display === 'none' || eventList.style.display === '') {
            eventList.innerHTML = ''; // Clear previous content
            events.forEach(event => {
                const li = document.createElement('li');
                li.textContent = `${event.title} - ${event.date}`;
                eventList.appendChild(li);
            });
            eventList.style.display = 'block';
        } else {
            eventList.style.display = 'none';
        }
    });
});

// Placeholder for API integration
function fetchEvents() {
    // Replace with fetch('/api/events') when backend is ready
    // fetch('/api/events')
    //   .then(response => response.json())
    //   .then(data => {
    //     events = data;
    //     showEvents();
    //   })
    //   .catch(error => console.error('Error fetching events:', error));
}