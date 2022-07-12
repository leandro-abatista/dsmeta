import icon from '../../assets/img/notification-icon.svg';
import './styles.css';
/**Declaração de função do javascript */
function NotificationButton() {
    return (
        <div className="dsmeta-red-btn">
            <img src={icon} alt="Notificar" />
        </div>
    )
}

export default NotificationButton;