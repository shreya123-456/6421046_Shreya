import styles from "../styles/CohortDetails.module.css";

export const CohortDetails = ({ cohort }) => {
  const { name, startedOn, status, coach, trainer } = cohort;

  // Choose color class based on status
  const statusColorClass =
    status.toLowerCase() === "ongoing" ? styles.ongoing : styles.scheduled;

  return (
    <div className={styles.box}>
      <h3 className={statusColorClass}>{name}</h3>
      <dl>
        <dt>Started On</dt>
        <dd>{startedOn}</dd>

        <dt>Current Status</dt>
        <dd>{status}</dd>

        <dt>Coach</dt>
        <dd>{coach}</dd>

        <dt>Trainer</dt>
        <dd>{trainer}</dd>
      </dl>
    </div>
  );
};
