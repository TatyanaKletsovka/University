test







        <li>
            <a href="${pageContext.request.contextPath}/controller?command=trainer_prepare_training_program_creation">${pageScope.create_training_program}</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/jsp/trainer/create_exercise.jsp">${pageScope.create_exercise}</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/controller?command=trainer_show_personal_clients">${pageScope.show_personal_clients}</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/controller?command=special_show_client_orders&client_id=${sessionScope.user.id}">${pageScope.orders_history}</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/controller?command=special_show_client_training_program&client_id=${sessionScope.user.id}">${pageScope.my_training_program}</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/controller?command=client_check_actual_order&client_id=${sessionScope.user.id}">${pageScope.make_order}</a>
        </li>


                       <c:forEach items="${faculty.subjects}" var="subject">
                       ${subject.name}