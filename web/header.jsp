<nav>
    <ul>
        <li ${param.title eq "home"?"class='currentPage'":""} ><a href="index.jsp">home</a></li>
        <li ${param.title eq "overview"?"class='currentPage'":""} ><a href="StudentInfo?command=overview">tabel</a></li>
        <li ${param.title eq "search"?"class='currentPage'":""} ><a href="zoekForm.jsp">zoeken</a></li>
        <li ${param.title eq "form"?"class='currentPage'":""} ><a href="studentForm.jsp">toevoegen</a></li>
    </ul>
</nav>

