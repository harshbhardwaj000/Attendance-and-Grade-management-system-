// Handle attendance submission
document.getElementById('attendanceForm').addEventListener('submit', function (e) {
    e.preventDefault();
    
    const studentName = document.getElementById('studentName').value;
    const attendance = document.getElementById('attendance').value;
    
    const attendanceRecord = `Student: ${studentName}, Attendance: ${attendance}`;
    
    const attendanceRecordsDiv = document.getElementById('attendanceRecords');
    const newRecord = document.createElement('p');
    newRecord.textContent = attendanceRecord;
    attendanceRecordsDiv.appendChild(newRecord);
    
    document.getElementById('attendanceForm').reset();
});

// Handle grade submission
document.getElementById('gradesForm').addEventListener('submit', function (e) {
    e.preventDefault();
    
    const studentName = document.getElementById('studentName').value;
    const subject = document.getElementById('subject').value;
    const grade = document.getElementById('grade').value;
    
    const gradeRecord = `Student: ${studentName}, Subject: ${subject}, Grade: ${grade}`;
    
    const gradeRecordsDiv = document.getElementById('gradeRecords');
    const newRecord = document.createElement('p');
    newRecord.textContent = gradeRecord;
    gradeRecordsDiv.appendChild(newRecord);
    
    document.getElementById('gradesForm').reset();
});
