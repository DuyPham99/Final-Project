import '../Login/index.scss';
import LoginForm from './LoginForm';
import { useDispatch, } from 'react-redux';
import login from 'actions/login';
import { getUser } from 'actions/login';
import { useHistory } from 'react-router';
function Login(props) {
    const history = useHistory();
    const dispatch = useDispatch();
    const handleSubmit = (data) => {
        dispatch(login(data));
        const dataToken = localStorage.getItem("token");
        if (dataToken) {
            history.replace("/")
        }
    }
    return (
        <div className="sign-in">
            <LoginForm onSubmit={handleSubmit} />
        </div>
    );
}
export default Login;