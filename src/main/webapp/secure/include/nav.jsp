<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav id="header_main">
    <div class="container_12">
        <!-- Start of the main navigation -->
        <ul id="nav_main">
            <li>
                <a href="#">
                    <img src="/resources/img/icons/25x25/dark/computer-imac.png" width=25 height=25 alt="">
                    Dashboard</a>
                <ul>
                    <li>
                        <a href="/secure/dashboard">Dashboard</a>
                    </li>
                    <li>
                        <a href="/secure/search">Name Search</a>
                    </li>
                </ul>
            </li>
            <li class="current">
                <a href="#">
                    <img src="/resources/img/icons/25x25/dark/documents.png" width=25 height=25 alt="">
                    My Companies</a>
                <ul>
                    <li class="current">
                        <a href="/secure/company/reserve">Reservations</a>
                    </li>
                    <li>
                        <a href="/secure/company/llp">LLP</a>
                    </li>
                    <li>
                        <a href="/secure/company/roc">ROC</a>
                    </li>
                    <li>
                        <a href="/secure/company/rob">ROB</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#">
                    <img src="/resources/img/icons/25x25/dark/address-book.png" width=25 height=25 alt="">
                    Literatures</a>
                <ul>
                    <li>
                        <a href="/secure/literature/legal">Legal</a>
                    </li>
                    <li>
                        <a href="/secure/literature/about">About</a>
                    </li>
                </ul>
            </li>
            <sec:authorize ifAllGranted="ROLE_ADMINISTRATOR">
                <li>
                    <a href="#">
                        <img src="/resources/img/icons/25x25/dark/archive.png" width=25 height=25 alt="">
                        Rules</a>
                    <ul>
                        <li>
                            <a href="/secure/filter/all">Filters</a>
                        </li>
                        <li>
                            <a href="/secure/name/all">Names</a>
                        </li>
                    </ul>
                </li>
            </sec:authorize>
        </ul>
        <!-- End of the main navigation -->
    </div>
</nav>
<div id="nav_sub"></div>
